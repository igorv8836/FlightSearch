package com.example.database

import android.content.Context
import androidx.room.Room
import com.example.database.dao.OfferDao
import com.example.database.dao.TicketDao
import com.example.database.dao.TicketsOfferDao
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> { provideDatabaseModule(get()) }
    single<OfferDao> { provideOfferDao(get()) }
    single<TicketsOfferDao> { provideTicketsOfferDao(get()) }
    single<TicketDao> { provideTicketDao(get()) }
}

internal fun provideDatabaseModule(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "database")
        .fallbackToDestructiveMigration()
        .build()
}

internal fun provideTicketsOfferDao(database: AppDatabase): TicketsOfferDao {
    return database.ticketsOfferDao()
}

internal fun provideTicketDao(database: AppDatabase): TicketDao {
    return database.ticketDao()
}

internal fun provideOfferDao(database: AppDatabase): OfferDao {
    return database.offerDao()
}