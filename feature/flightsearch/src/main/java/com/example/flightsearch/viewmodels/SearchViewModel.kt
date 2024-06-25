package com.example.flightsearch.viewmodels

import androidx.lifecycle.ViewModel
import com.example.flightsearch.R
import com.example.flightsearch.models.RecommendedDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


internal class SearchViewModel : ViewModel() {
    private val _destinations: MutableStateFlow<List<RecommendedDestination>> =
        MutableStateFlow(emptyList())
    val destinations: StateFlow<List<RecommendedDestination>> = _destinations
    private val _fromCity: MutableStateFlow<String> = MutableStateFlow("")
    val fromCity: StateFlow<String> = _fromCity

    init {
        getDestinations()
    }

    private fun getDestinations() {
        _destinations.value = listOf(
            RecommendedDestination(R.drawable.recommendation1, "Стамбул", "Популярное направление"),
            RecommendedDestination(R.drawable.recommendation2, "Сочи", "Популярное направление"),
            RecommendedDestination(R.drawable.recommendation3, "Пхукет", "Популярное направление")
        )
    }

    fun setFromCity(city: String) {
        _fromCity.value = city
    }
}