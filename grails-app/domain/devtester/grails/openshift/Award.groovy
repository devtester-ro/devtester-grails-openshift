package devtester.grails.openshift

class Award {

    Date awardDate
    String type
    Integer points

    //child to Customer
    static belongsTo = [customer: Customer]

    static constraints = {
    }
}
