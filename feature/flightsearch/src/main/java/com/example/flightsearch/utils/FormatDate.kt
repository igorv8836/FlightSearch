package com.example.flightsearch.utils

import java.util.Calendar
import java.util.Locale

fun Long.getDayFromMillis(): Int{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this

    return calendar.get(Calendar.DAY_OF_MONTH)
}

fun Long.getMonthFromMillis(): String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this

    val month = calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale("ru"))
    return month?.lowercase(Locale("ru"))?.dropLast(1) ?: ""
}

fun Long.getWeekDayFromMillis(): String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = this

    val dayOfWeek = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale("ru"))
    return dayOfWeek?.lowercase(Locale("ru")) ?: ""
}