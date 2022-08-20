package org.shiva.kotlin.basics.nullable

import java.lang.IllegalArgumentException


fun main() {
    // Kotlin checks for Null at compile time by adding @Nullable @NotNullable annotations
    // no performance hit since they are annoatations at compile time
    val name = "Siva"
//    val country = null // compile time error
    val country: String? = null // use question mark to insist for null, here country is called nullable type

    println(name.length)
//    println(country.length) //compile time error
    println(country?.length) //safe access with '?'

    val region = country // region is also a nullable type
    val province = country ?: "India" // use elvis operator to make it non nullable

    // kotlin smart casting
    val status: String? = "Green"
    if (status == null) throw IllegalArgumentException();
    //kotlin smart cast
    println(status.length) // Kotlin knows you made null check earlier so you don't need to use safe type status?.length


    // nullabilitiy with lists
    fun foo(list1: List<Int?>, list2: List<Int>?) {
        list1.size
        list2?.size

        val firstItem: Int? = list1.get(0)
        val firstItemInList2: Int? = list2?.get(0) //forces you to make item also nullable when list is nullable
    }

    // isEmptyOrNull function
    fun String?.isEmptyOrNull(): Boolean  {
        return this == null || this.isEmpty()
    }
    val s1: String? = null
    val s2: String? = ""
    val s3: String = ""
    val s4: String = "some value"

    println("isEmptyOrNull")
    println(s1.isEmptyOrNull())
    println(s2.isEmptyOrNull())
    println(s3.isEmptyOrNull())
    println(s4.isEmptyOrNull())

    //safe cast vs cast to nullable type
    // this is similar to instance of in java
    val rate = "abc"
    println(rate as? Int) // prints null
    println(rate as Int?) // throws exception


    // you can throw NPE
    val s: String? = null
    s!! //throws NPE but try to avoid and utilize type safety(?), elvis (?:) and if checks

}
