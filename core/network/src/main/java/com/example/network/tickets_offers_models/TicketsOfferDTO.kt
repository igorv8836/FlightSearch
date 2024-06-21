package com.example.network.tickets_offers_models

import com.example.network.tickets_models.Price
import com.squareup.moshi.Json

data class TicketsOfferDTO(
    val id: Int,
    val price: Price,
    @Json(name = "time_range") val timeRange: List<String>,
    val title: String
)