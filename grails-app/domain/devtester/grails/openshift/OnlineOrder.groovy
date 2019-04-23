package devtester.grails.openshift

class OnlineOrder {

    Date orderDate
    Integer orderNumber
    Float orderTotal

    //child to Customer
    static belongsTo = [customer: Customer]

    //parent for OrderItem
    static hasMany = [orderItems: OrderItem]

    static constraints = {
    }
}
