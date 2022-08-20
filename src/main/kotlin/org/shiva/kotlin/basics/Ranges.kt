package org.shiva.kotlin.basics

fun main() {
    //strings are compared lexicographically
    val contains = "ball" in "a".."k";

    println(contains)

    //Every comparable type can be used like below
    // Eg: if(myDate in startDate..endDate) {...}

    for (x in 1..9) {
        print(x)
    }
}