package com.example.data.models

import com.example.database.entities.OfferEntity
import com.example.network.offers_models.OfferDTO
import com.example.network.offers_models.OffersResponse

data class Offer(
    val id: Int,
    val title: String,
    val town: String,
    val price: Int
)

fun OfferEntity.toOffer() = Offer(id, title, town, price)

fun OfferDTO.toDbEntity() = OfferEntity(id, title, town, price.value)