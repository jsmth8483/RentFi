package com.example.rentifi.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.rentifi.database.models.Property

@Dao
interface PropertyDao {
    @Insert
    suspend fun insert(property: Property)

    @Delete
    suspend fun delete(property: Property)

    @Query("SELECT * FROM property_table")
    fun findAll(): LiveData<List<Property>>
}