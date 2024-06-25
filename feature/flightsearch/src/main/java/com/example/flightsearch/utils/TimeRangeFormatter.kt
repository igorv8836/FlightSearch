package com.example.flightsearch.utils

import com.example.data.models.TicketsOffer

internal fun TicketsOffer.timeRangeToString(): String {
    return this.timeRange.joinToString(" ")
}