package com.example.constanta.domain.repository

import com.example.constanta.domain.models.Film
import com.example.constanta.domain.models.FilmsResponse
import retrofit2.Response


interface FilmRepository {
    suspend fun getAllFilms(): Response<FilmsResponse>
}