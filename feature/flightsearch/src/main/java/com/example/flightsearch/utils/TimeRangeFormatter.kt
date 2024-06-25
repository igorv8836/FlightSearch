package com.example.flightsearch.utils

import com.example.data.models.TicketsOffer

fun TicketsOffer.timeRangeToString(): String {
    return this.timeRange.joinToString(" ")
}