package devtester.grails.openshift

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {

        def firstName = params?.firstName
        def totalPoints = params.points?.toInteger()

        def welcomeMessage = ""

        switch (totalPoints) {
            case 5:
                welcomeMessage = "Welcome back $firstName, this drink is on us"
                break
            case 4:
                welcomeMessage = "Welcome back $firstName, your next drink is free"
                break
            case 2..3:
                welcomeMessage = "Welcome back $firstName, you have $totalPoints points"
                break
            default:
                welcomeMessage = "Welcome $firstName. Thanks for registering"
                break
        }

    }

    def getTotalPoints(Customer customer) {
        def totalAwards = 0
        customer.awards.each {
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards
        return customer
    }

    def processCheckin(lookup) {

        def customer = Customer.findByPhone(lookup.phone)

        //Check for new customer
        if (customer == null) {
            customer = lookup
            customer.firstName = "Customer"
        }

        //Set total awards
        def totalAwards = 0
        customer.awards.each {
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards

        //Create welcome message
        def welcomeMessage = ""
        switch (totalAwards) {
            case 5:
                welcomeMessage = "Welcome back $customer.firstName, this drink is on us"
                break
            case 4:
                welcomeMessage = "Welcome back $customer.firstName, your next drink is free"
                break
            case 1..3:
                welcomeMessage = "Welcome back $customer.firstName, you have $totalAwards points"
                break
            default:
                welcomeMessage = "Welcome $customer.firstName. Thanks for registering"
                break
        }

        if (totalAwards < 5) {
            customer.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else {
            customer.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: -5))
        }

        //Save to the database
        customer.save(flush: true)

        return [customer, welcomeMessage]
    }

}
