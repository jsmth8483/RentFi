package com.example.rentifi.database.models

import androidx.room.Relation

data class UnitWithTenants(
    val unit: Unit,
    @Relation(parentColumn = "unitNo", entityColumn = "unitNo")
    val tenant: Tenant
)
