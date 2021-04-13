package com.example.rentifi.property

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PropertyViewModelFactory(private val address: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PropertyViewModel::class.java)) {
            return PropertyViewModel(address) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}