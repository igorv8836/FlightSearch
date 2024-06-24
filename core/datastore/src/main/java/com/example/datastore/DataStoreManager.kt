package com.example.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DataStoreManager(private val dataStore: DataStore<Preferences>) {

    companion object {
        val LAST_CITY_KEY = stringPreferencesKey("last_city")
    }

    val lastCityFlow: Flow<String?> = dataStore.data
        .map { preferences ->
            preferences[LAST_CITY_KEY]
        }

    suspend fun saveLastCity(city: String) {
        withContext(Dispatchers.IO) {
            dataStore.edit { preferences ->
                preferences[LAST_CITY_KEY] = city
            }
        }
    }
}