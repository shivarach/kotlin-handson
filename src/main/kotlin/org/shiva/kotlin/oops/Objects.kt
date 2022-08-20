package org.shiva.kotlin.oops

import org.shiva.kotlin.oops.JDBCConnection.foo
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun main() {
    val booking = BookingService.book()
    println(booking)
    val create = BookingService2.create()
    /*
    Calling companion object(means static methods) from java
    1) BookingService2.Companion.create()
    2) BookingService2.create() - if @JvmStatic is added before the fun in companion object
     */
    // if calling from java BookingService2.Companion.create()


    val appointment = Appointment.fromJSON("{firstNme: 'shiva'")
}

// object means singleton - kotlin generates java singleton behind the scenes

object JDBCConnection {
    fun foo() {}
}

// object can also be used as an expression means analogous to java anonymous class
/*
window.addMouseLitener(
    object: MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            //....
        }
        override fun mouseEntered(e: MouseEvent?) {
           //...
        }
    }
)*/

// ##################### companion object #########################
/*
- A companion object is a special object inside a class
- they can be used as static methods in kotlin since kotlin doesn't have any static
 */

class BookingService {
    companion object {
        fun book() = 1 // add @JvmStatic before fun to access it from java like `BookingService.book()`
    }
}

// companion objects can implement an interface

interface Factor<T> {
    fun create() : T
}

class BookingService2 {
    private constructor()
    companion object: Factor<BookingService2> {
        override fun create(): BookingService2 {
            return BookingService2()
        }
    }
}


class Appointment(val firstName: String) {
    companion object {
    }
}
// companion object can be a receiver of extension function
fun Appointment.Companion.fromJSON(json: String) : Appointment {
    return Appointment("from json")
}
