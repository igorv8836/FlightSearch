package com.example.data.repositories

import com.example.data.models.TicketsOffer
import kotlinx.coroutines.flow.Flow

interface TicketsOfferRepository {
    fun getTicketsOffer(id: Int): Flow<TicketsOffer>
    fun getTicketsOffers(): Flow<List<TicketsOffer>>
}