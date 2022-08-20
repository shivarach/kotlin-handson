package org.shiva.kotlin.functional

fun main() {
    val heroes = listOf(
            Hero("The Captain", 60, Gender.MALE),
            Hero("Frenchy", 42, Gender.MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, Gender.FEMALE),
            Hero("First Mate", 29, Gender.MALE),
            Hero("Sir Stephen", 37, Gender.MALE))

    // method reference
//    println(heroes.maxBy { it.age })
    println(heroes.maxByOrNull(Hero::age)) //same as above

    // you can store lambda in a variable but not function
    // Use functions if lambda is very bigger
    val isEvenLambda = { number: Int -> number % 2 == 0}
    val predicate = isEvenLambda

    fun isEvenFunction(number: Int): Boolean {
        return number % 2 == 0
    }
//    val anotherPredicate = isEvenFunction // compile time error
    val anotherIsEvenPredicate = ::isEvenFunction //works

    println(anotherIsEvenPredicate(2))


    //Non-bound reference i.e you can call it on any person object
    class Person(val name: String, val age: Int) {
        fun isOlder(ageLimit: Int) = age > ageLimit
    }

    val agePredicate : (Person, Int) -> Boolean = Person::isOlder

    val shiva = Person("Shiva", 20)
    println(agePredicate(shiva, 25))

    // bounded context i.e bounded to an object
    val agePredicateBounded : (Int) -> Boolean = shiva::isOlder
    println(agePredicateBounded(25))

    //lambda returns from whole function
    fun duplicateNonZeroElements(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return listOf()
            listOf(it, it)
        }
    }
    // returns from whole function
    println("duplicateNonZeroElements: ${duplicateNonZeroElements(listOf(1, 2, 0))}")

    // above problem can be solved by using labels or nested function or anonymized function
    fun duplicateNonZeroElements1(list: List<Int>): List<Int> {
        return list.flatMap {
            if (it == 0) return@flatMap listOf<Int>() //add @flatMap
            listOf(it, it)
        }
    }
    // returns from whole function
    println("duplicateNonZeroElements: ${duplicateNonZeroElements1(listOf(1, 2, 0))}")


}
