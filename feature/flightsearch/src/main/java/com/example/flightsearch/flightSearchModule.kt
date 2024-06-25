package com.example.flightsearch

import com.example.flightsearch.viewmodels.OffersViewModel
import com.example.flightsearch.viewmodels.RouteDetailsViewModel
import com.example.flightsearch.viewmodels.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val flightSearchModule = module {
    viewModel { OffersViewModel(get(), get(), get()) }
    viewModel { SearchViewModel() }
    viewModel { RouteDetailsViewModel(get()) }
}