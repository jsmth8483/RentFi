package com.example.rentifi.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.example.rentifi.database.dao.PropertyDao


class HomeViewModel(val database: PropertyDao, application: Application): AndroidViewModel(application) {

    var data = database.findAll()

}