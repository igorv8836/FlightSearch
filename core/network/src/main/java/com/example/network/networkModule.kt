package com.example.network

import com.example.network.api.OffersApi
import com.example.network.api.TicketsApi
import com.example.network.api.TicketsOffersApi
import com.example.network.api.createOffersApi
import com.example.network.api.createTicketsApi
import com.example.network.api.createTicketsOffersApi
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
    single<Retrofit> { retrofit(NetworkConstants.BASE_URL) }
    single<OffersApi> { createOffersApi(get()) }
    single<TicketsApi> { createTicketsApi(get()) }
    single<TicketsOffersApi> { createTicketsOffersApi(get()) }
}