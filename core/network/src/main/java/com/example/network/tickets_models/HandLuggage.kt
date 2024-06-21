package com.example.network.tickets_models

import com.squareup.moshi.Json

data class HandLuggage(
    @Json(name = "has_hand_luggage") val hasHandLuggage: Boolean,
    val size: String?
)