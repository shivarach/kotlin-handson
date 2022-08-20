package org.shiva.kotlin

import org.shiva.kotlin.oops.BookingService

fun main() {
    println(AA.prop)
    println(AAA().prop)
}
// use const for all primitive types and strings
const val answer: Int = 44


// use @JvmField for non-primitive types
/*
The below kotlin is same as below java
public static final BookingService service = new BookingService()
 */
@JvmField  // Exposes as filed in java Eg: org.shiva.kotlin.ConstantsKt.service
val service = BookingService()

object AA {
    @JvmField
    val prop = D() // static field generated
}

class AAA {
    @JvmField
    val prop = D() // regular field generated
}

class D