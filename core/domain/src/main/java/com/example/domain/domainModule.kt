package com.example.domain

import org.koin.dsl.module

val domainModule = module {
    factory<GetOffersUseCase> { GetOffersUseCase(get()) }
    factory<GetTicketsOffersUseCase> { GetTicketsOffersUseCase(get()) }
    factory<GetTicketsUseCase> { GetTicketsUseCase(get()) }
}