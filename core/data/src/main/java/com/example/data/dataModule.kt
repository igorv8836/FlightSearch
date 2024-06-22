package com.example.data

import com.example.data.repositories.OfferRepository
import com.example.data.repositories.TicketRepository
import com.example.data.repositories.TicketsOfferRepository
import com.example.data.repositoriesImpl.OfferRepositoryImpl
import com.example.data.repositoriesImpl.TicketRepositoryImpl
import com.example.data.repositoriesImpl.TicketsOfferRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<OfferRepository> { OfferRepositoryImpl(get(), get()) }
    single<TicketsOfferRepository> { TicketsOfferRepositoryImpl(get(), get()) }
    single<TicketRepository> { TicketRepositoryImpl(get(), get()) }
}