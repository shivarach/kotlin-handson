package org.shiva.kotlin

fun main() {

}

// generic interfaces and classes
interface MyList<E> {
    fun get(index: Int): E
}

fun foo(ints: MyList<Int>) {}
fun bar(strings: MyList<String>) {}

// generic functions
fun <T> List<T>.myFilter(predicate: (T) -> Boolean): List<T> {
    val destination = ArrayList<T>()
    for (element in this) {
        if (predicate(element)) destination.add(element)
    }
    return destination
}

fun use1(ints: List<Int>) {
    ints.myFilter { it > 0 }
}

fun use2(strings: List<String>) {
    strings.myFilter { it.isNotBlank() }
}


// nullable generic argument
fun <T> List<T>.firstOrNull(): T? {
    return this.get(0)
}

fun use3() {
    val ints = listOf<Int>(1, 2)
    val first = ints.firstOrNull()
}

// to enforce passing non-null values, extend the type with any
// Any can be replaced with some super type eg: Comparable
fun <T : Any> List<T>.firstOrNull1(): T? {
    return this.get(0)
}

fun use4() {
//    val ints = listOf<Int>(1, 2, null) //error
    val ints = listOf<Int>(1, 2)
}


