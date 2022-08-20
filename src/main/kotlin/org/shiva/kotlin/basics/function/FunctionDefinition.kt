/*
@file:JvmName("Util") // With this name(Util) we can call functions from java eg: Util.displayCharacter();
 */
package org.shiva.kotlin.basics.function

/*
block body
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b;
}
*/
// expression body
fun max(a: Int, b: Int): Int = if (a > b) a else b

//function returning Unit (Unit is similar to void)
fun displayMax(a: Int, b: Int) {
    println(max(a, b))
}
/*
The above function is equivalent below
fun displayMax(a: Int, b: Int): Unit {
    println(max(a, b))
}
 */

//function with default values
@JvmOverloads // to utilize default parameters when calling from java
fun displayCharacter(character: Char = '#', size: Int = 10) {
    repeat(size) {
        print(character);
    }
    println()
}