package com.example.database.entities.ticketEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hand_luggage")
data class HandLuggageEntity(
    @PrimaryKey(autoGenerate = true) val handLuggageId: Int = 0,
    val hasHandLuggage: Boolean,
    val size: String?
)