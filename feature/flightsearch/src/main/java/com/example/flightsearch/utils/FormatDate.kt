package com.example.flightsearch.utils

import android.annotation.SuppressLint
import com.example.data.models.Ticket
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.abs

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

fun Ticket.getDepartureTime(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date: Date? = dateFormat.parse(departure.date)
    return date?.let { outputDateFormat.format(it) } ?: ""
}

fun Ticket.getArrivalTime(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val date: Date? = dateFormat.parse(arrival.date)
    return date?.let { outputDateFormat.format(it) } ?: ""
}

@SuppressLint("DefaultLocale")
fun Ticket.getDuration(): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val departureDate: Date? = dateFormat.parse(departure.date)
    val arrivalDate: Date? = dateFormat.parse(arrival.date)

    if (departureDate != null && arrivalDate != null) {
        val durationInMillis = abs(arrivalDate.time - departureDate.time)
        val durationInHours = durationInMillis / (1000 * 60 * 60).toDouble()
        return String.format("%.1f", durationInHours)
    }

    return ""
}

