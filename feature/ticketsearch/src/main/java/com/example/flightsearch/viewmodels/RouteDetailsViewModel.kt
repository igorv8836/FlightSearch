package com.example.flightsearch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.Ticket
import com.example.data.models.TicketsOffer
import com.example.domain.GetTicketsOffersUseCase
import com.example.domain.GetTicketsUseCase
import com.example.flightsearch.models.TicketFilter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class RouteDetailsViewModel(
    private val getTicketsOffersUseCase: GetTicketsOffersUseCase,
    private val getTicketsUseCase: GetTicketsUseCase
) : ViewModel() {
    private val _ticketFilter: MutableStateFlow<TicketFilter> =
        MutableStateFlow(
            TicketFilter(
                "",
                "",
                System.currentTimeMillis(),
                1,
                null
            )
        )
    val ticketFilter: StateFlow<TicketFilter> = _ticketFilter
    private val _ticketsOffer = MutableStateFlow(emptyList<TicketsOffer>())
    val ticketsOffer: StateFlow<List<TicketsOffer>> = _ticketsOffer

    private val _tickets = MutableStateFlow<List<Ticket>>(emptyList())
    val tickets: StateFlow<List<Ticket>> = _tickets

    init {
        getTicketsOffer()
    }

    fun setFromCity(city: String) {
        _ticketFilter.value = _ticketFilter.value.copy(fromCity = city)
    }

    fun setToCity(city: String) {
        _ticketFilter.value = _ticketFilter.value.copy(toCity = city)
    }

    fun setDate(date: Long) {
        _ticketFilter.value = _ticketFilter.value.copy(date = date)
    }

    fun setReturnDate(date: Long) {
        _ticketFilter.value = _ticketFilter.value.copy(returnDate = date)
    }

    private fun getTicketsOffer(){
        viewModelScope.launch {
            getTicketsOffersUseCase.invoke().collect{
                _ticketsOffer.value = it
            }
        }
    }

    fun getTickets(){
        viewModelScope.launch {
            getTicketsUseCase.invoke().collect{
                _tickets.value = it
            }
        }
    }
}