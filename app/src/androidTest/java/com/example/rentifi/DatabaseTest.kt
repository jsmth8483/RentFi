package com.example.rentifi

import androidx.lifecycle.Transformations
import androidx.room.Room
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.rentifi.database.RentFiDatabase
import com.example.rentifi.database.models.Property
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.Executors

//@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    @Test
    fun insertPropertyTest() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val database = Room.inMemoryDatabaseBuilder(
            appContext, RentFiDatabase::class.java
        )
            .setTransactionExecutor(Executors.newSingleThreadExecutor())
            .build()
        val property = Property(title = "testProp", address = "123 1st St")
        runBlocking {
            database.propertyDao.insert(property)
        }
        val data = database.propertyDao.findAll()
        val transData = Transformations.map(data) {
            it
        }
        assertThat(transData, equalTo("testProp"))
    }

}