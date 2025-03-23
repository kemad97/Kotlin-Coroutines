package com.example.kotlincoroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

suspend fun main() : Unit = coroutineScope {

    val sharedFlow = MutableSharedFlow<Int>()

    launch {
        sharedFlow.collect {
            println("first: $it")
        }
    }

    launch {
        sharedFlow.collect {
            println("sec: $it")
        }
    }

    sharedFlow.emit(1)
    sharedFlow.emit(2)


}