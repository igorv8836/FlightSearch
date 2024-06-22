package com.example.domain

import com.example.data.repositories.TicketsOfferRepository

class GetTicketsOffersUseCase(
    private val ticketsOfferRepository: TicketsOfferRepository
) {
    fun invoke() = ticketsOfferRepository.getTicketsOffers()
}