package com.example.counterapp

// Data class to represent the Counter model
data class CounterModel(var count: Int)

// Repository class to handle data operations for the counter
class CounterRepository() {
    private var counter = CounterModel(0) // Initialize counter with 0

    // Function to get the current counter model
    fun getCounter() = counter

    // Function to increment the counter value
    fun incrementCounter() {
        counter.count++
    }

    // Function to decrement the counter value
    fun decrementCounter() {
        counter.count--
    }
}
