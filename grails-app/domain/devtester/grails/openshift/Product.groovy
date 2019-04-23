package devtester.grails.openshift

class Product {

    //Fields
    String name
    String sku
    Float price

    static hasMany = [orderItems: OrderItem]

    static constraints = {
    }
}
