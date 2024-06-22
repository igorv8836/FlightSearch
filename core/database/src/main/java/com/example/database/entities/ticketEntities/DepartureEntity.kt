package com.example.database.entities.ticketEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departure")
data class DepartureEntity(
    @PrimaryKey(autoGenerate = true) val departureId: Int,
    val airport: String,
    val date: String,
    val town: String
)