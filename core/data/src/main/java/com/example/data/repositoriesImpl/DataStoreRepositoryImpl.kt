package com.example.data.repositoriesImpl

import com.example.data.repositories.DataStoreRepository
import com.example.datastore.DataStoreManager
import kotlinx.coroutines.flow.Flow

internal class DataStoreRepositoryImpl(private val dataStoreManager: DataStoreManager): DataStoreRepository {
    override suspend fun saveLastCity(city: String){
        dataStoreManager.saveLastCity(city)
    }
    override fun getLastCity(): Flow<String?> {
        return dataStoreManager.lastCityFlow
    }
}