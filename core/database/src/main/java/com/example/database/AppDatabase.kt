package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.database.dao.OfferDao
import com.example.database.dao.TicketDao
import com.example.database.dao.TicketsOfferDao
import com.example.database.entities.OfferEntity
import com.example.database.entities.TicketEntity
import com.example.database.entities.TicketsOfferEntity
import com.example.database.entities.ticketEntities.ArrivalEntity
import com.example.database.entities.ticketEntities.DepartureEntity
import com.example.database.entities.ticketEntities.HandLuggageEntity
import com.example.database.entities.ticketEntities.LuggageEntity

@Database(
    entities = [
        OfferEntity::class,
        TicketsOfferEntity::class,
        TicketEntity::class,
        ArrivalEntity::class,
        DepartureEntity::class,
        HandLuggageEntity::class,
        LuggageEntity::class
    ],
    version = 1
)
@TypeConverters(ListStringConverter::class)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun ticketsOfferDao(): TicketsOfferDao
    abstract fun ticketDao(): TicketDao
    abstract fun offerDao(): OfferDao
}