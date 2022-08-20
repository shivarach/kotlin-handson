package org.shiva.kotlin.coroutine

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() {

    /**
     * Sometimes, after we have triggered some long-running asynchronous computation,
     * we want to cancel it because we’re no longer interested in the result.
     */

    runBlocking { // For testing - The name of runBlocking means that the thread that runs it (in this case — the main thread) gets blocked for the duration of the call, until all the coroutines inside runBlocking { ... } complete their execution.
        val launchedJob =
            launch(Dispatchers.Default) { // launch coroutine builder which launches a new coroutine concurrently with the rest of the code, which continues to work independently.
                while (isActive) println("Coroutine is active...")
            }

        delay(1000L)

        launchedJob.cancel()

        if (launchedJob.isActive) println("Still running") else println("Coroutine was cancelled")
    }

    println("----------------------------------------------------------------")
    /**
     * When we’re requesting some processing and are not sure how much time that computation will take,
     * it’s advisable to set the timeout on such an action. If the processing does not finish within the given timeout,
     * we’ll get an exception, and we can react to it appropriately.
     */

    try {
        runBlocking {
            withTimeout(2000L) {
                launch {
                    repeat(100) { i ->
                        println("Some expensive computation $i ...")
                        delay(500L)
                    }
                }
            }
        }
    } catch (e: TimeoutCancellationException) {
        println("Oops! ${e.message}")
    }


    println("----------------------------------------------------------------")

    /**
     * Let’s say that we need to start two asynchronous actions concurrently and wait for their results afterward.
     * If our processing takes one second and we need to execute that processing twice, the runtime of synchronous
     * blocking execution will be two seconds.

    It would be better if we could run both those actions in separate threads and wait for those results in the
    main thread.

    We can leverage the async() coroutine to achieve this by starting processing in two separate threads concurrently:
     */

    runBlocking {
        val timeMillis = measureTimeMillis {
            val one = async(Dispatchers.Default) { expensiveComputation(mutableListOf()) }
            val two = async(Dispatchers.Default) { expensiveComputation(mutableListOf()) }

            runBlocking {
                one.await()
                two.await()
            }
        }
        println(timeMillis)
    }

    println("----------------------------------------------------------------")

    /**
     * The main difference between async and launch is that launch is used for starting a computation that isn't
     * expected to return a specific result. launch returns Job, which represents the coroutine.
     * It is possible to wait until it completes by calling Job.join().
     *
     * Deferred is a generic type which extends Job. An async call can return a Deferred<Int> or
     * Deferred<CustomType> depending on what the lambda returns (the last expression inside the lambda is the result).
     *
     * To get the result of a coroutine, we call await() on the Deferred instance. While waiting for the result,
     * the coroutine that this await is called from, suspends:
     */

    runBlocking {
        val deferred: Deferred<Int> = async {
            loadData()
        }
        println("waiting...")
        println(deferred.await()) // awaits until coroutine finishes and returns whatever returned by async func
    }


} // end of main

suspend fun loadData(): Int {
    println("loading...")
    delay(1000L)
    println("loaded!")
    return 42
}




