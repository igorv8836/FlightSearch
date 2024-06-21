package com.example.network.tickets_models

import com.squareup.moshi.Json

data class TicketDTO(
    val arrival: Arrival,
    val badge: String?,
    val company: String,
    val departure: Departure,
    @Json(name = "hand_luggage") val handLuggage: HandLuggage,
    @Json(name = "has_transfer") val hasTransfer: Boolean,
    @Json(name = "has_visa_transfer") val hasVisaTransfer: Boolean,
    val id: Int,
    @Json(name = "is_exchangable") val isExchangable: Boolean,
    @Json(name = "is_returnable") val isReturnable: Boolean,
    val luggage: Luggage,
    val price: Price,
    @Json(name = "provider_name") val providerName: String
)