package com.example.data

import com.example.data.repositories.DataStoreRepository
import com.example.data.repositories.OfferRepository
import com.example.data.repositories.TicketRepository
import com.example.data.repositories.TicketsOfferRepository
import com.example.data.repositoriesImpl.DataStoreRepositoryImpl
import com.example.data.repositoriesImpl.OfferRepositoryImpl
import com.example.data.repositoriesImpl.TicketRepositoryImpl
import com.example.data.repositoriesImpl.TicketsOfferRepositoryImpl
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factory { OfferRepositoryImpl(get(), get()) } bind(OfferRepository::class)
    factory { TicketsOfferRepositoryImpl(get(), get()) } bind(TicketsOfferRepository::class)
    factory { TicketRepositoryImpl(get(), get()) } bind(TicketRepository::class)
    factory { DataStoreRepositoryImpl(get()) } bind(DataStoreRepository::class)
}