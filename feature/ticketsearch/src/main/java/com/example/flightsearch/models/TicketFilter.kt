package com.example.flightsearch.models

internal data class TicketFilter(
    val toCity: String,
    val fromCity: String,
    val date: Long,
    val countPeople: Int,
    val returnDate: Long? = null
)