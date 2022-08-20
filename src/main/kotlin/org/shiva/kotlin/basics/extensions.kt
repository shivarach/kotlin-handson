package org.shiva.kotlin.basics
//extensions are regular java static functions
//extensions can't be overridden(since they are java static functions)
//if extension has same signature as members, extensions will be shadowed
//extensions can be used to write auxiliary apis as extension by keeping minimalistic members in abstraction
//extensions comes handy when you want extend third party interfaces
fun <T> List<T>.getOrNull1(index: Int) =
    if (index in 0 until size) this[index] else null

fun List<Int>.mysum(): Int  {
    var result = 0
    for (i in this) {
        result += i
    }
    return result
}

fun main() {
    val list = listOf(1, 2, 3)
    val value = list.getOrNull1(2)
    println(value)

    val sum = list.mysum()
    println(sum)
}