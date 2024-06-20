package com.example.counterapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// ViewModel class to manage UI-related data in a lifecycle-conscious way
class CounterViewModel(private val _repository: CounterRepository) : ViewModel() {
    // Private mutable state variable _count initialized with the value from the repository
    private var _count = mutableIntStateOf(_repository.getCounter().count)

    // Public immutable state variable count that reflects the value of _count
    val count: Int
        get() = _count.intValue

    // Function to increment the counter value
    fun increment() {
        _repository.incrementCounter() // Update the repository
        _count.intValue = _repository.getCounter().count // Reflect the updated value in the ViewModel
    }

    // Function to decrement the counter value
    fun decrement() {
        if (_count.intValue > 0) {
            _repository.decrementCounter() // Update the repository
            _count.intValue = _repository.getCounter().count // Reflect the updated value in the ViewModel
        }
    }
}
