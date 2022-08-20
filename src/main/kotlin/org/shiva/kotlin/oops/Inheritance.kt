package org.shiva.kotlin.oops

fun main() {
    Parent("parent shiva")
    Child("child shiva")
    AnotherChild("child Shiva", 33)
}

interface Base

class BaseImpl : Base

// all classes are final by default in kotlin
// 'open' allows you to extend a class, similarly on methods - mark it as open if you want to override
open class Parent(val name: String)
class Child(name: String) : Parent(name) //observe val is not provided

class AnotherChild(name: String, age: Int) : Parent(name) {
}