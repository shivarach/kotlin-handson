package org.shiva.kotlin.properties

// lazy
val lazyValue: String by lazy {
    println("computed")
    "hello"
}

fun main() {
    println(lazyValue)
    println(lazyValue) //observe computed is not printed second item
}

// lateinit -- for spring
// use lateinit for spring autowire
// it must be var not val
// lateinit can't be primitive

lateinit var myData: List<String>

// check whether lateinit var is initialized
//this::myData.isInitialized