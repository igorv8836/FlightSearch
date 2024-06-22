package com.example.network.tickets_models

import com.squareup.moshi.Json

data class TicketDTO(
    val id: Int,
    val badge: String?,
    val price: Price,
    @Json(name = "provider_name") val providerName: String,
    val company: String,
    val departure: Departure,
    val arrival: Arrival,
    @Json(name = "has_transfer") val hasTransfer: Boolean,
    @Json(name = "has_visa_transfer") val hasVisaTransfer: Boolean,
    val luggage: Luggage,
    @Json(name = "hand_luggage") val handLuggage: HandLuggage,
    @Json(name = "is_returnable") val isReturnable: Boolean,
    @Json(name = "is_exchangable") val isExchangable: Boolean,
)