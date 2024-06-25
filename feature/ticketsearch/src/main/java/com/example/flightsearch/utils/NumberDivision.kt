package com.example.flightsearch.utils

internal fun String.divideIntoThreeDigits(): String {
    return try {
        this.replace(Regex("(\\d)(?=(\\d{3})+(?!\\d))"), "$1 ")
    } catch (e: Exception) {
        this
    }
}