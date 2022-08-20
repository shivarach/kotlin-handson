package org.shiva.kotlin.basics.conditional

// if is an expression
fun printMax(a: Int, b: Int) {
    val max = if (a > b) a else b;
    println(max)
}

// 'when' bit similar to switch
enum class Color {
    BLUE, ORANGE, RED
}
fun getDescription(color: Color): String =
    when (color) {
        Color.BLUE -> "Cold"
        Color.ORANGE -> "Mild"
        Color.RED -> "Hot"
    }
fun respondToInput(input: String) = when (input) {
    "y", "yes" -> "Agreed!"
    "n", "no" -> "Sorry!"
    else -> "Its ok!"
}
// when can used where multile if-else conditions are required
