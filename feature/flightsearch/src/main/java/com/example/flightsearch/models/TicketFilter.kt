package com.example.flightsearch.models

data class TicketFilter(
    val toCity: String,
    val fromCity: String,
    val date: Long,
    val returnDate: Long? = null
)