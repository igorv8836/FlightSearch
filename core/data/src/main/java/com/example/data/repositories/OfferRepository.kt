package com.example.data.repositories

import com.example.data.models.Offer
import kotlinx.coroutines.flow.Flow

interface OfferRepository {
    fun getOffer(id: Int) : Flow<Offer>
    fun getOffers() : Flow<List<Offer>>
}