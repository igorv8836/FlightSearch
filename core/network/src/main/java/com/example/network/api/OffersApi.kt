package com.example.network.api

import com.example.network.offers_models.OffersResponse
import retrofit2.Retrofit
import retrofit2.http.GET

interface OffersApi {
    @GET("/v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getOffers(): OffersResponse
}

internal fun createOffersApi(retrofit: Retrofit): OffersApi {
    return retrofit.create(OffersApi::class.java)
}