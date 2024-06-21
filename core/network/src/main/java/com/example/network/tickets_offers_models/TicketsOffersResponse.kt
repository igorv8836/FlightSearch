package com.example.network.tickets_offers_models

import com.squareup.moshi.Json

data class TicketsOffersResponse(
    @Json(name = "tickets_offers") val ticketsOffers: List<TicketsOfferDTO>
)