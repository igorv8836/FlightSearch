package com.example.domain

import com.example.data.repositories.DataStoreRepository

class SaveLastCityUseCase(private val dataStoreRepository: DataStoreRepository) {
    suspend fun invoke(city: String) = dataStoreRepository.saveLastCity(city)
}