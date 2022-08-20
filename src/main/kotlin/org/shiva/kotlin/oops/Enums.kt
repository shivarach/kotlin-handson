package org.shiva.kotlin.oops

import org.shiva.kotlin.oops.Color.ORANGE
import org.shiva.kotlin.oops.ColorWithProps.BLUE

fun main() {
    getDescription(ORANGE)
    println(BLUE.r)
    println(BLUE.rgb())
}
// enum
enum class Color {
    BLUE, ORANGE, RED
}

fun getDescription(color: Color) {
    when(color) {
        Color.BLUE -> println("COLD")
        ORANGE -> println("MILD")
        Color.RED -> println("HOT")
    }
}

//enum with properties
enum class ColorWithProps( val r: Int, val g: Int, val b: Int) {
    BLUE(0, 0, 255), ORANGE(255, 165, 0), RED(255, 0, 0);
    fun rgb() = ( r * 256 + g) * 256 + b
}

