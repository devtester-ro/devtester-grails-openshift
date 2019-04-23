package devtester.grails.openshift

class OrderItem {

    Integer qty
    Float total

    static belongsTo = [order: OnlineOrder, product: Product]

    static constraints = {
    }
}
