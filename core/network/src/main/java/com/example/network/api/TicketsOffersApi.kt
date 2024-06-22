package com.example.network.api

import com.example.network.tickets_offers_models.TicketsOffersResponse
import retrofit2.Retrofit
import retrofit2.http.GET

interface TicketsOffersApi {
    @GET("/v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getTicketsOffers(): TicketsOffersResponse
}

internal fun createTicketsOffersApi(retrofit: Retrofit): TicketsOffersApi {
    return retrofit.create(TicketsOffersApi::class.java)
}