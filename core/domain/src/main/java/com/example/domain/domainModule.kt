package com.example.domain

import org.koin.dsl.module

val domainModule = module {
    factory { GetOffersUseCase(get()) }
    factory { GetTicketsOffersUseCase(get()) }
    factory { GetTicketsUseCase(get()) }
    factory { GetLastCityUseCase(get()) }
    factory { SaveLastCityUseCase(get()) }
}