package com.example.network.tickets_models

import com.squareup.moshi.Json

data class Luggage(
    @Json(name = "has_luggage") val hasLuggage: Boolean,
    val price: Price?
)