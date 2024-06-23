package com.example.data.repositoriesImpl

import com.example.data.models.TicketsOffer
import com.example.data.models.toDbEntity
import com.example.data.models.toTicketsOffer
import com.example.data.repositories.TicketsOfferRepository
import com.example.database.dao.TicketsOfferDao
import com.example.network.api.TicketsOffersApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class TicketsOfferRepositoryImpl(
    private val networkService: TicketsOffersApi,
    private val database: TicketsOfferDao
) : TicketsOfferRepository {
    override fun getTicketsOffer(id: Int): Flow<TicketsOffer> {
        return database.getById(id).map { it.toTicketsOffer() }
    }

    override fun getTicketsOffers(): Flow<List<TicketsOffer>> {
        val databaseFlow = database.getAll().map { it.map { it1 -> it1.toTicketsOffer() } }
        return flow {
            emit(databaseFlow.first())
            val res = networkService.getTicketsOffers()
            database.deleteAll()
            database.insert(res.ticketsOffers.map { it.toDbEntity() })
            emitAll(databaseFlow)
        }.flowOn(Dispatchers.IO).catch { emitAll(databaseFlow) }
    }
}