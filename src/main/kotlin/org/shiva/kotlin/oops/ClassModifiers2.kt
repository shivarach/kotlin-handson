package org.shiva.kotlin.oops

fun main() {

}

// ############## sealed classes ################

/*
Sealed classes restricts class hierarchy, means all subclasses must be located in the same file
 */

sealed class Expression
class Num(val value: Int) : Expression()
class Sum(val left: Expression, val right: Expression) : Expression()

fun eval(expression: Expression): Int = when(expression) {
    is Num -> expression.value
    is Sum -> eval(expression.left) + eval(expression.right)
    // if `Expression` is not sealed we might need to add a else branch throw an exception here
}

// ############## nested/inner class ##################
/*
Java:
    - a nested class can be static or non-static(inner class)
    - only inner class can refer members of parent class means it has reference of outer class
    - static class can't refer members of parent class
Kotlin:
    - due to memory leak issues kotlin makes all inner classes as static
    - however parent class memebers can be refered like below
 */

class ParentClass {
    val name: String = ""
    inner class innerclass { // inner keyword
        init {
            this@ParentClass.name // accessing parent member fields
        }
    }
}
