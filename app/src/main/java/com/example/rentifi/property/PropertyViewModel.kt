package com.example.rentifi.property

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rentifi.database.models.Property
import kotlinx.coroutines.launch
import timber.log.Timber

class PropertyViewModel(var address: String): ViewModel() {

}