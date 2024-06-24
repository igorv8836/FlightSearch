package com.example.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

internal val Context.dataStore by preferencesDataStore(name = "user_data")

val dataStoreModule = module {
    single { androidContext().dataStore }
    single { DataStoreManager(get()) }

}