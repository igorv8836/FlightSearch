package com.example.database.entities.ticketEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "luggage")
data class LuggageEntity(
    @PrimaryKey(autoGenerate = true) val luggageId: Int,
    val hasLuggage: Boolean,
    val price: Int?
)