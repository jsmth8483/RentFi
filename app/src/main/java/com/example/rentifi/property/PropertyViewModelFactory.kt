package com.example.rentifi.property

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rentifi.database.dao.PropertyDao
import com.example.rentifi.database.models.Property

class PropertyViewModelFactory(
    private val property: Property,
    private val dataSource: PropertyDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PropertyViewModel::class.java)) {
            return PropertyViewModel(property, dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}