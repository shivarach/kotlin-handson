package org.shiva.kotlin.functional

fun main() {
//    val isEven: (Int) -> (Boolean) = { number: Int -> number % 2 == 0 }
    val isEven = { number: Int -> number % 2 == 0 } //same as above
    println(isEven)
    println(isEven(2))

    val integers = listOf(1, 2, 3, 4)
    println(integers.any(isEven))
    println(integers.filter(isEven))

    //calling lambda directly
    run { println("Hello")}

    /* suppose you have a method in java like below
    void postponeComputation(int delay, Runnable runnable)
    You can call it from kotlin like below

    postponeComputation(1000) { println("Delayed") } // or
    val runnable = Runnable { println("Delayed") }
    postponeComputation(1000, runnable)
     */

    // lambda which returns null i.e when you call
    val f2 : () -> Int? = { null }
    println("lambda which returns null: ${f2()}")

    //either lambda returning int or null reference
    val f3 : (() -> Int)? = if (true) { null } else null
    println("either lambda returning int or null reference: ${f3?.invoke()}") // or if check

}