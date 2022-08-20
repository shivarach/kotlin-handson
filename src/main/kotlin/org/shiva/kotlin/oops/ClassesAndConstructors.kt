package org.shiva.kotlin.oops

fun main() {
    val a = A()
//    Person()  //empty constructor is not provided if arugments based consutructor is available
    val person = Person("shiva", 22)
    val personWithInit = PersonWithInit("shiva", 22)
    Rectangle(4)
    Rectangle(2, 4)
}

// default constructor is provided by kotlin compiler
class A

// Abstract class example
abstract class B {
    abstract fun test(): String
}

//if at least one argument constructor is available, no default constructor would be provided
class Person(val name: String, val age: Int)

class Rectangle(val height: Int, val width: Int) // primary constructor
{
    //secondary constructor which must call primary or any other secondary constructor
    constructor(side: Int) : this(side, side) {}
}

/*
The following PersonWithInit is same as Person class above
 */

class PersonWithInit(name: String, age: Int) {

    private val age: Int
    private val name: String

    init {
        //write complex constructor logic here
        this.name = name
        this.age = age
    }
}




