package devtester.grails.openshift

class Customer {

    String firstName
    String lastName
    String email
    Long phone
    Integer totalPoints

    static hasMany = [awards: Award, orders: OnlineOrder]

    static constraints = {
        phone()
        firstName(nullable: true)
        lastName(nullable: true)
        email(nullable: true, email: true)
        totalPoints(nullable: true, max: 10)
    }
}
