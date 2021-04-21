package com.example.rentifi.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.rentifi.database.models.Property

@Dao
interface PropertyDao {
    @Insert
    suspend fun insert(property: Property)

    @Delete
    suspend fun delete(property: Property)

    @Query("SELECT * FROM property_table WHERE id = :id")
    suspend fun find(id: Long): Property?

    @Query("SELECT * FROM property_table")
    fun findAll(): LiveData<List<Property>>


}