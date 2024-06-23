package com.example.data.repositoriesImpl

import com.example.data.models.Offer
import com.example.data.models.toDbEntity
import com.example.data.models.toOffer
import com.example.data.repositories.OfferRepository
import com.example.database.dao.OfferDao
import com.example.network.api.OffersApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

internal class OfferRepositoryImpl(
    private val networkService: OffersApi,
    private val database: OfferDao
) : OfferRepository {
    override fun getOffer(id: Int): Flow<Offer> {
        return database.getById(id).map { it.toOffer() }
    }

    override fun getOffers(): Flow<List<Offer>> {
        val databaseFlow = database.getAll().map { entities -> entities.map { it.toOffer() } }

        return flow {
            emit(databaseFlow.first())
            val offers = networkService.getOffers()
            database.deleteAll()
            database.insert(offers.offers.map { it.toDbEntity() })
            emitAll(databaseFlow)
        }.flowOn(Dispatchers.IO).catch {
            emitAll(databaseFlow)
        }
    }
}