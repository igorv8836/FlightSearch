package com.example.data.repositories

import com.example.data.models.Ticket
import kotlinx.coroutines.flow.Flow

interface TicketRepository {
    fun getTicket(id: Int): Flow<Ticket>
    fun getTickets(): Flow<List<Ticket>>
}