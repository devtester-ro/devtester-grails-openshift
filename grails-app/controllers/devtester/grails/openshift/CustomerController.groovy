package devtester.grails.openshift

import grails.gorm.transactions.Transactional

@Transactional
class CustomerController {

    static scaffold = Customer

    def calculationsService

    def lookup() {
        def customer = Customer.findAllByLastNameLikeAndTotalPointsGreaterThanEquals("B%", 2)
        [customerList: customer]
    }

    def index() {
        params.max = 10
        [customerList: Customer.list(params), customerCount: Customer.count()]
    }

    def create() {
        [customer: new Customer()]
    }

    def save(Customer customer) {
        customer.save()
        redirect(action: "show", id: customer.id)
    }

    def show(Long id) {
        def customer = Customer.get(id)
        customer = calculationsService.getTotalPoints(customer)
        [customer: customer]
    }

    def edit(Long id) {
        def customer = Customer.get(id)
        [customer: customer]
    }

    def update(Long id) {
        def customer = Customer.get(id)
        customer.properties = params
        customer.save(flush: true)
        redirect(action: "show", id: customer.id)
    }

    def delete(Long id) {
        def customer = Customer.get(id)
        customer.delete(flush: true)
        redirect action: "index"
    }

    def checkin() {}
}
