package org.shiva.kotlin.basics.exceptions

import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.time.seconds

fun main() {
    // throw is an expression
    // no checked exceptions in kotlin
    val number = 4;
    val percentage = if (number in 0..100)
        number
    else
        throw IllegalArgumentException("Invalid percentage!")

    println("percentage $percentage")

    //try is an expression

    val height = try {
        val stringNumber = "shiva"
        Integer.parseInt(stringNumber);
    } catch (e: NumberFormatException) {
        null
        //return //to return from this function
    }
 listOf(1,2).getOrNull(0)
    println(height);

    //Need to add @Throws annotation for checked exceptions if they are used in java ow compile time error
    @Throws(IOException::class)
    fun bar() { throw IOException()}
}

fun test() {
    val list = mutableListOf(1, 2, 3, 4, 5, 6, null);
    val nonNull = list.filterNotNull()
    println(list)
    println(nonNull)
    println(list.filterNotNull().filter {it % 2 == 0})
}
