package com.example.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.database.entities.ticketEntities.ArrivalEntity
import com.example.database.entities.ticketEntities.DepartureEntity
import com.example.database.entities.ticketEntities.HandLuggageEntity
import com.example.database.entities.ticketEntities.LuggageEntity

@Entity(tableName = "ticket")
data class TicketEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val badge: String?,
    val price: Int,
    val providerName: String,
    val company: String,
    @Embedded(prefix = "departure_") val departure: DepartureEntity,
    @Embedded(prefix = "arrival_") val arrival: ArrivalEntity,
    val hasTransfer: Boolean,
    val hasVisaTransfer: Boolean,
    @Embedded(prefix = "luggage_") val luggage: LuggageEntity,
    @Embedded(prefix = "handLuggage_") val handLuggage: HandLuggageEntity,
    val isReturnable: Boolean,
    val isExchangable: Boolean,
)