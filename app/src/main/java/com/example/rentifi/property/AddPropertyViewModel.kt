package com.example.rentifi.property

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentifi.database.dao.PropertyDao
import com.example.rentifi.database.models.Property
import kotlinx.coroutines.launch

class AddPropertyViewModel(val database: PropertyDao, application: Application): AndroidViewModel(application) {

    fun onSave(propertyTitle: String, propertyAddress: String) {
        viewModelScope.launch {
            val newProperty = Property(title = propertyTitle, address = propertyAddress)
            insert(newProperty)
        }
    }
    private suspend fun insert(newProperty: Property) {
        database.insert(newProperty)
    }
}