package com.example.flightsearch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.Offer
import com.example.domain.GetOffersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OffersViewModel(
    private val getOffersUseCase: GetOffersUseCase
) : ViewModel() {

    private val _offers: MutableStateFlow<List<Offer>?> = MutableStateFlow(null)
    val offers: StateFlow<List<Offer>?>
        get() = _offers


    fun getOffers() {
        viewModelScope.launch {
            getOffersUseCase.invoke().collect {
                _offers.value = it
            }
        }
    }
}