package com.example.kotlincoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

fun main() = runBlocking {
    val channel = Channel<Int>()

    launch {
        for (i in 1..5) {
            channel.send(i)
        }
        channel.close()
    }


    for (x in channel) {
        println("Recv : $x")
    }


}
