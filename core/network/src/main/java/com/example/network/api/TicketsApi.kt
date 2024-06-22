package com.example.network.api

import com.example.network.tickets_models.TicketsResponse
import retrofit2.Retrofit
import retrofit2.http.GET

interface TicketsApi {
    @GET("/v3/c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTickets(): TicketsResponse
}

internal fun createTicketsApi(retrofit: Retrofit): TicketsApi {
    return retrofit.create(TicketsApi::class.java)
}