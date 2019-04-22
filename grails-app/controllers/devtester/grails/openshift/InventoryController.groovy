package devtester.grails.openshift

class InventoryController {

    //Action 1
    def index() {
        render "Here is a list of everything."
    }

    //Action 2
    def edit() {
        //variables
        def productName = "Breakfast Blend"
        def sku = "BB01"

        //map - key in the view and value is the variable
        [product:productName, sku:sku]
    }

    //Action 3
    def remove() {
        render "You have one less than before."
    }
}
