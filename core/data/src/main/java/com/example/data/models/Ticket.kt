package com.example.data.models

import com.example.database.entities.TicketEntity
import com.example.database.entities.ticketEntities.ArrivalEntity
import com.example.database.entities.ticketEntities.DepartureEntity
import com.example.database.entities.ticketEntities.HandLuggageEntity
import com.example.database.entities.ticketEntities.LuggageEntity
import com.example.network.tickets_models.Arrival
import com.example.network.tickets_models.Departure
import com.example.network.tickets_models.TicketDTO
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

data class Ticket(
    val id: Int,
    val badge: String?,
    val price: Int,
    val providerName: String,
    val company: String,
    val departure: FlightEvent,
    val arrival: FlightEvent,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    val luggage: Luggage,
    val handLuggage: HandLuggage,
    val isReturnable: Boolean,
    val isExchangable: Boolean,
)

data class FlightEvent(
    val airport: String,
    val date: String,
    val town: String
)

data class HandLuggage(
    val hasHandLuggage: Boolean,
    val size: String?
)

data class Luggage(
    val hasLuggage: Boolean,
    val price: Int?
)

fun ArrivalEntity.toFlightEvent() = FlightEvent(airport, date, town)

fun DepartureEntity.toFlightEvent() = FlightEvent(airport, date, town)

fun HandLuggageEntity.toHandLuggage() = HandLuggage(hasHandLuggage, size)

fun LuggageEntity.toLuggage() = Luggage(hasLuggage, price)

fun Arrival.toDbEntity() = ArrivalEntity(0, airport, date, town)

fun Departure.toDbEntity() = DepartureEntity(0, airport, date, town)

fun com.example.network.tickets_models.HandLuggage.toDbEntity() = HandLuggageEntity(0, hasHandLuggage, size)

fun com.example.network.tickets_models.Luggage.toDbEntity() = LuggageEntity(0, hasLuggage, price?.value)

fun TicketEntity.toTicket() = Ticket(
    id,
    badge,
    price,
    providerName,
    company,
    departure.toFlightEvent(),
    arrival.toFlightEvent(),
    hasTransfer,
    hasVisaTransfer,
    luggage.toLuggage(),
    handLuggage.toHandLuggage(),
    isReturnable,
    isExchangable
)

fun TicketDTO.toDbEntity() = TicketEntity(
    0,
    badge,
    price.value,
    providerName,
    company,
    departure.toDbEntity(),
    arrival.toDbEntity(),
    hasTransfer,
    hasVisaTransfer,
    luggage.toDbEntity(),
    handLuggage.toDbEntity(),
    isReturnable,
    isExchangable
)