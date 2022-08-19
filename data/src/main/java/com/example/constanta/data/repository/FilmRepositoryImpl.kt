package com.example.constanta.data.repository

import com.example.constanta.data.network.FilmsApiService
import com.example.constanta.domain.models.Film
import com.example.constanta.domain.models.FilmsResponse
import com.example.constanta.domain.repository.FilmRepository
import retrofit2.Response


class FilmRepositoryImpl(val networkModule: FilmsApiService): FilmRepository {

    override suspend fun getAllFilms(): Response<FilmsResponse> {
        return networkModule.getFilms()
    }

}