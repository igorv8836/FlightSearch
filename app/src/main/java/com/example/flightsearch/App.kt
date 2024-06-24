package com.example.flightsearch

import android.app.Application
import com.example.common.commonModule
import com.example.data.dataModule
import com.example.database.databaseModule
import com.example.datastore.dataStoreModule
import com.example.domain.domainModule
import com.example.network.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                commonModule,
                dataModule,
                databaseModule,
                domainModule,
                networkModule,
                dataStoreModule,
                flightSearchModule
            )
        }

    }
}