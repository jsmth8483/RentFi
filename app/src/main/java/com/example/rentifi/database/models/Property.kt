package com.example.rentifi.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "property_table")
data class Property (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "address")
    var address: String = ""

)