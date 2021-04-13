package com.example.rentifi.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "unit_table", primaryKeys = ["unitNo", "propertyId"])
data class Unit (
    @ColumnInfo(name = "unit_no")
    var unitNo: Int?,
    @ColumnInfo(name = "property_id")
    var propertyId: Long = 0
)