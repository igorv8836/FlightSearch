package com.example.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "offer")
data class OfferEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val town: String,
    val price: Int
)