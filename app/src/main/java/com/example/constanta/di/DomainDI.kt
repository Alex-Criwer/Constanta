package com.example.constanta.di

import com.example.constanta.domain.usecases.GetAllFilmsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetAllFilmsUseCase(filmRepository = get())
    }
}