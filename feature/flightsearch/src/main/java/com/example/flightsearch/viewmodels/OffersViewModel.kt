package com.example.flightsearch.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.Offer
import com.example.domain.GetLastCityUseCase
import com.example.domain.GetOffersUseCase
import com.example.domain.SaveLastCityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OffersViewModel(
    private val getOffersUseCase: GetOffersUseCase,
    private val getLastCityUseCase: GetLastCityUseCase,
    private val saveLastCityUseCase: SaveLastCityUseCase
) : ViewModel() {

    private val _offers: MutableStateFlow<List<Offer>?> = MutableStateFlow(null)
    val offers: StateFlow<List<Offer>?> = _offers
    private val _lastCity: MutableStateFlow<String?> = MutableStateFlow(null)
    val lastCity: StateFlow<String?> = _lastCity

    init {
        getLastCity()
    }


    fun getOffers() {
        viewModelScope.launch {
            getOffersUseCase.invoke().collect {
                _offers.value = it
            }
        }
    }

    private fun getLastCity(){
        viewModelScope.launch {
            getLastCityUseCase.invoke().collect {
                _lastCity.value = it
            }
        }
    }

    fun saveLastCity(city: String){
        viewModelScope.launch {
            saveLastCityUseCase.invoke(city)
        }
    }
}