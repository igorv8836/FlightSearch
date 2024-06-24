package com.example.domain

import com.example.data.repositories.DataStoreRepository

class GetLastCityUseCase(
    private val dataStoreRepository: DataStoreRepository
) {
    fun invoke() = dataStoreRepository.getLastCity()
}