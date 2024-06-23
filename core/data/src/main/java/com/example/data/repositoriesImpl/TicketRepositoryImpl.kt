package com.example.data.repositoriesImpl

import com.example.data.models.Ticket
import com.example.data.models.toDbEntity
import com.example.data.models.toTicket
import com.example.data.repositories.TicketRepository
import com.example.database.dao.TicketDao
import com.example.network.api.TicketsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class TicketRepositoryImpl(
    private val networkService: TicketsApi,
    private val database: TicketDao
) : TicketRepository {
    override fun getTicket(id: Int): Flow<Ticket> {
        return database.getById(id).map { it.toTicket() }
    }

    override fun getTickets(): Flow<List<Ticket>> {
        val databaseFlow = database.getAll().map { it.map { it1 -> it1.toTicket() } }
        return flow {
            emit(databaseFlow.first())
            val res = networkService.getTickets()
            database.deleteAll()
            database.insert(res.tickets.map { it.toDbEntity() })
            emitAll(databaseFlow)
        }.flowOn(Dispatchers.IO).catch { emitAll(databaseFlow) }
    }
}