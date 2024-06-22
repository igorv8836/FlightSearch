package com.example.flightsearch

import android.app.Application
import com.example.database.databaseModule
import com.example.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(networkModule, databaseModule)
        }

    }
}