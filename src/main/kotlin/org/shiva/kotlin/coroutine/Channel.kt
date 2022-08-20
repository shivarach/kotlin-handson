package org.shiva.kotlin.coroutine

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val fixedBufferChannel = Channel<String>(3) //channel which always holds max 3 document paths which can be consumed by consumers for scanning

        launch {
            addAllTheDocumentsWhichShouldBeScanned(fixedBufferChannel)
        }
        launch {
            delay(1000L)
            while (!fixedBufferChannel.isEmpty) {
                delay(1000L)
                scanTheDocuments(fixedBufferChannel)
            }
        }
    }
}

suspend fun scanTheDocuments(fixedBufferChannel: Channel<String>) {
    val documentPath = fixedBufferChannel.receive()
    delay(1000L)
    println("Document $documentPath Scanned successfully! ")
}

suspend fun addAllTheDocumentsWhichShouldBeScanned(fixedBufferChannel: Channel<String>) {
    repeat(10) {
        val documentPath = "DocumentPath/$it"
        fixedBufferChannel.send(documentPath)
        println("Found document $documentPath for scanning!")
    }
}
