package org.shiva.kotlin.properties

//same as java class where getter for name and getter and settter for address
class Contact(
        val name: String,
        var address: String
)

class Rectangle(val height: Int, val width: Int) {
    //isSquare can be used as field
    val isSquare: Boolean
        get() {
            return height == width;
        }
}

fun main() {
    val shivaContact = Contact("Shiva", "Hyderabad")
    println(shivaContact.address)
    println(shivaContact.name)

    val rectangle = Rectangle(10, 10)
    println(rectangle.isSquare)
}

//provide feasibility to mutate inside but make only readable to outside

class LengthCounter {
    var counter: Int = 0
        private set
}