package org.shiva.kotlin


fun main() {
    val input = "shiva Rachakonda"
    println(input.makeFirstLetterUpperCase())
    println(    fibonacciSeq.take(5).toList()
    )
}

fun String?.makeFirstLetterUpperCase(): String {
    return this?.substring(0, 1)?.toUpperCase() + this?.substring(1)
}

val fibonacciSeq = sequence {
    var a = 0
    var b = 1

    yield(1)

    while (true) {
        yield(a + b)

        val tmp = a + b
        a = b
        b = tmp
    }
}