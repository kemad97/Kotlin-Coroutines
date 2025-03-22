package com.example.kotlincoroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take

fun getNumbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}

fun getNumbers2(): Flow<Int> = flow {
    for (i  in 2..40 step 2) {
        delay(1000)
        emit(i)
    }
}

suspend fun main() = coroutineScope {
    getNumbers()
        .filter { it > 2 }
        .collect { num ->
            println("num iis: $num")
        }

    getNumbers2()
        .take(10)
        .collect { num ->
            println("num2 iis: $num")
        }
}
