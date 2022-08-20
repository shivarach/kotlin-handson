package org.shiva.kotlin.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A coroutine is an instance of suspendable computation. It is conceptually similar to a thread,
 * in the sense that it takes a block of code to run that works concurrently with the rest of the code.
 * However, a coroutine is not bound to any particular thread. It may suspend its execution in one thread
 * and resume in another one.
 *
 * Coroutines are very lightweight
 *
 * A suspend function can be called only from Coroutines - launch, async or runBlocking(use runBlocking only for tests)
 */
fun main() {
    val input = mutableListOf<String>()


    runBlocking { // For testing - The name of runBlocking means that the thread that runs it (in this case — the main thread) gets blocked for the duration of the call, until all the coroutines inside runBlocking { ... } complete their execution.
        launch { // launch coroutine builder which launches a new coroutine concurrently with the rest of the code, which continues to work independently.
            expensiveComputation(input)
        }
        input.add("Hello") // Observe Hello gets added first because above coroutine works independently(like thread in java)
    }

    println(input)
}

suspend fun expensiveComputation(input: MutableList<String>) {
    delay(1000L) //delay is a special suspending function. It suspends the coroutine for a specific time
    input.add("World!")
}



