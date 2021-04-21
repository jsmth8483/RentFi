package com.example.rentifi.property

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rentifi.database.dao.PropertyDao
import com.example.rentifi.database.models.Property

class PropertyViewModel(
    val property: Property,
    val dataSource: PropertyDao,
    application: Application
) : AndroidViewModel(application) {

    private val _propertyTitle = MutableLiveData<String>()
    val propertyTitle: LiveData<String>
        get() = _propertyTitle

    init {
        _propertyTitle.value = property.title
    }


    // TODO: Get this working with only passing id into view model then getting remaining data from database
    /*var property = MutableLiveData<Property>()
    val propertyTitle = Transformations.map(property) {
        it?.title
        Timber.d("${it?.title}")
    }

    init {
        initializeProperty()
    }

    private fun initializeProperty() {
        viewModelScope.launch {
            property.value = getPropertyFromDatabase()
            Timber.d("${property.value?.title}")
        }
    }

    private suspend fun getPropertyFromDatabase(): Property? = dataSource.find(id)

*/
}