package com.example.data.repositories

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun saveLastCity(city: String)
    fun getLastCity(): Flow<String?>
}