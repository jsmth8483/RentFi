package com.example.rentifi

import android.app.Application
import timber.log.Timber

class RentiFiApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}