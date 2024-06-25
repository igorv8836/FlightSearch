package com.example.flightsearch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.Ticket
import com.example.domain.GetTicketsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TicketsViewModel(
    private val getTicketsUseCase: GetTicketsUseCase
): ViewModel() {

    private val _tickets = MutableStateFlow<List<Ticket>>(emptyList())
    val tickets: StateFlow<List<Ticket>> = _tickets

    init {
        getTickets()
    }

    private fun getTickets(){
        viewModelScope.launch {
            getTicketsUseCase.invoke().collect{
                _tickets.value = it
            }
        }
    }

}