package org.shiva.kotlin.oops

fun main() {
    val foo = Foo(1, 2)
    val foo2 = Foo(1, 2)

    println(foo == foo2) // false because '==' checks reference since equals method is not available
    println(foo === foo2) // false because '===' always checks reference

    val bar = Bar(1, 2)
    val bar2 = Bar(1, 2)

    println(bar == bar2) // true because equals will be called which is generated automatically for kotlin data classes
    println(bar === bar2) // false because '===' checks references

}

// ################ data classes #####################
/*
the following methods will be declared for data classes
equals, hashcode, tostring, copy
- equals will be generated for all props in primary constructor
 */

class Foo(val first: Int, val second: Int)
data class Bar(val first: Int, val second: Int)

