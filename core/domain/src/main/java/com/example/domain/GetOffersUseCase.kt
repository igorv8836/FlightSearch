package com.example.domain

import com.example.data.repositories.OfferRepository

class GetOffersUseCase(
    private val offerRepository: OfferRepository
) {
    suspend fun invoke() = offerRepository.getOffers()
}