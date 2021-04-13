package com.example.rentifi.database.models

import androidx.room.Relation

data class PropertyWithUnits(
    val property: Property,
    @Relation(parentColumn = "id", entityColumn = "propertyId")
    val unit: Unit
)
