package com.example.data.models

import com.example.database.entities.TicketsOfferEntity
import com.example.network.tickets_offers_models.TicketsOfferDTO

data class TicketsOffer(
    val id: Int,
    val price: Int,
    val timeRange: List<String>,
    val title: String
)

fun TicketsOfferEntity.toTicketsOffer() = TicketsOffer(id, price, timeRange, title)

fun TicketsOfferDTO.toDbEntity() = TicketsOfferEntity(0, price.value, timeRange, title)