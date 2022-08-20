package org.shiva.kotlin.functional

fun main() {
    val list = listOf(1, 2, 3)
    // below threea re valid syntaxes for lambda
    println(list.any({item: Int -> item > 1}))
    println(list.any({item -> item > 1})) //type removed
    println(list.any() { item -> item > 1})
    println(list.any { item -> item > 1}) // recommended for multiline lambdas
    // if there is only one type, can be replaced with 'it'
    println(list.any { it > 1}) //recommended for single line lambdas

}