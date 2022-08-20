package org.shiva.kotlin.functional

import org.shiva.kotlin.functional.Gender.FEMALE
import org.shiva.kotlin.functional.Gender.MALE

data class Hero(
        val name: String,
        val age: Int,
        val gender: Gender?
)

enum class Gender {
    MALE, FEMALE
}

fun main() {
    // common operations in collections
    // filter, map, find(all, none), find, first/firstOrNull, count, partition, groupBy, associateBy, associate, zip, zipWithNext, flatten, flatMap

    val heroes = listOf(
            Hero("The Captain", 60, MALE),
            Hero("Frenchy", 42, MALE),
            Hero("The Kid", 9, null),
            Hero("Lady Lauren", 29, FEMALE),
            Hero("First Mate", 29, MALE),
            Hero("Sir Stephen", 37, MALE))

    println("last: ${heroes.last().name}")
    println("fistOrNull: ${heroes.firstOrNull { it.age == 30}?.name}")
//    heroes.first { it.age == 30}.name // NoSuchElementException
    println("map: ${heroes.map { it.age }.distinct().size}")
    println("filter: ${heroes.filter { it.age < 30 }.size}")
    val (youngest, oldest) = heroes.partition { it.age < 30 }
    println("partition: ${oldest.size}")
    // use maxBy or minBy with lambda if they are not comparable
    println("maxBy: ${heroes.maxByOrNull { it.age }?.name}")
    println("predicate all: ${heroes.all {it.age < 50}}")
    println("predicate any: ${heroes.any {it.gender == FEMALE}}")

    //groupBy and maxBy
    val ageToHeroesMap: Map<Int, List<Hero>> = heroes.groupBy { it.age }
    val (age: Int, heroesList: List<Hero>) = ageToHeroesMap.maxByOrNull { (_, group) -> group.size }!!
    println("Age of heroes with big group: $age")

    //associateBy --use only when you target elements are unique
    val nameToHeroes: Map<String, Hero> = heroes.associateBy { it.name }
    println("associate ${nameToHeroes["Frenchy"]?.age}")
    println("associate ${nameToHeroes.getValue("Frenchy").age}") // throws NoSuchElementException



}


