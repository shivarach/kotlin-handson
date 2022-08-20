fun main() { // arguments to main are optional
    println("Hello world") // semicolon is optional
    val name = "Kotlin"
    println("Hello $name")

    // 'if' can be used as an expression in Kotlin
    val status = if (1 > 0) "Yes" else "No"
    println(status);

    // ################# variables #################
    // Try to define all the variables with as val
    val pi: Double = 3.14 // val is like final in java
   // pi = 2.14; error
    var height: Int = 100
    height = 200

    //type inference
    var weight = 130 // type inferred to int automatically

    //Lists: mutable and read-only
    val mutableList = mutableListOf("Java")
    mutableList.add("Kotlin")

    val list = listOf("Java")
//    list.add("Kotlin") compile time error



}
