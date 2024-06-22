package com.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tickets_offer")
data class TicketsOfferEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val price: Int,
    val timeRange: List<String>,
    val title: String
)