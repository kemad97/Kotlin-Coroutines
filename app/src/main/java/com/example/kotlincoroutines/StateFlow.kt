package com.example.kotlincoroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

suspend fun main() : Unit = coroutineScope {

    val stateFlow = MutableStateFlow <Int> (0)

    launch {
       for (i in 1..5) {
           stateFlow.value = i
         //  delay(100)

       }
    }

   stateFlow.collect{
       println( it)
   }

}