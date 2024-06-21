package com.example.network.offers_models

import com.example.network.tickets_models.Price

data class OfferDTO(
    val id: Int,
    val title: String,
    val town: String,
    val price: Price
)