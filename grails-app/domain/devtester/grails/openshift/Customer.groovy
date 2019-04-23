package devtester.grails.openshift

class Customer {

    String firstName
    String lastName
    Long phone
    Integer totalPoints

    static hasMany = [awards: Award, orders: OnlineOrder]

    static constraints = {
    }
}
