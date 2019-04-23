package devtester.grails.openshift


class WhiteboardController {

    def calculationsService

    def index() {}

    def variables() {

        /** Groovy can figure out what type of variable you are def
         * if your variable has no quotes = number
         * if it has quotes = string
         * if you are using a function like date it will assume it's a date
         */

        def myTotal = 1
        render("Total: " + myTotal)
        render("<br>" + myTotal.class + "<br>")

        def firstName = "Mike"
        render("<br>Name: " + firstName)
        render("<br>" + firstName.class + "<br>")

        def today = new Date()
        render("<br>Today is: " + today)
        render("<br>" + today.class + "<br>")

        /** Before hitting refresh to see the results
         * guess what type of variable has "whatVariable"
         */

        def whatVariable = 1.0
        render("<br>Guess the type: " + whatVariable)
        render("<br>" + whatVariable.class + "<br>")

    }

    def strings() {

        /** Some String magic
         *  Different way to concat strings
         *  Check the size of a strings
         *  Make it lowercase
         */

        def first = "Mike"
        def last = "Kelly"

        def input = "SomethiNGTHatHaslowerUPPER"

        def fullName = first + last

        def points = 4

        render "Welcome back " +  " " + first + "." + "You have " + points + " " + "points<br>"

        render "<br>Hey there $first. You already have $points points<br>"

        render "<br>Today is ${new Date()}<br>"
        render "<br>Your full name is: $fullName and has: ${fullName.size()} characters<br>"

        render "<br>Everything to lower: ${input.toLowerCase()}<br>"

    }


    def conditions() {

        /** Example of condition in groovy
         *  As you can see it accepts ranges "2..3"
         */

        def firstName = "Mike"
        def totalPoints = 5
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
        }

        render welcomeMessage
    }

    def conditionsParams() {
        def welcomeMessage = calculationsService.welcome(params)

        render welcomeMessage
    }
}

