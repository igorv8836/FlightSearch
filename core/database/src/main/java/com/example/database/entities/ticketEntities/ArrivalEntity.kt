package com.example.database.entities.ticketEntities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "arrival")
data class ArrivalEntity(
    @PrimaryKey(autoGenerate = true) val arrivalId: Int,
    val airport: String,
    val date: String,
    val town: String
)