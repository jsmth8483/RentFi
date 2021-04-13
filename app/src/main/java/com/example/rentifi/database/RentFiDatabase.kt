package com.example.rentifi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rentifi.database.dao.PropertyDao
import com.example.rentifi.database.models.Property
import com.example.rentifi.database.models.Tenant

@Database(entities = [Property::class, Tenant::class], version = 1, exportSchema = false)
abstract class RentFiDatabase: RoomDatabase() {
    abstract val propertyDao: PropertyDao

    companion object {
        @Volatile
        private var INSTANCE: RentFiDatabase? = null

        fun getInstance(context: Context): RentFiDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RentFiDatabase::class.java,
                        "rentfi_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}