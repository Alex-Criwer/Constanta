package com.example.constanta.di


import com.example.constanta.BuildConfig
import com.example.constanta.data.network.FilmsApiService
import com.example.constanta.data.repository.FilmRepositoryImpl
import com.example.constanta.domain.repository.FilmRepository

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val dataModule = module {
    single{createNetworkModule()}

    single<FilmRepository> {
        FilmRepositoryImpl(networkModule = get())
    }
}

internal fun createNetworkModule(): FilmsApiService {
    return Retrofit
        .Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FilmsApiService::class.java)
}