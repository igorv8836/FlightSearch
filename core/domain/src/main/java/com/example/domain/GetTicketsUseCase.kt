package com.example.domain

import com.example.data.repositories.TicketRepository

class GetTicketsUseCase(
    private val ticketsRepository: TicketRepository
) {
    fun invoke() = ticketsRepository.getTickets()
}