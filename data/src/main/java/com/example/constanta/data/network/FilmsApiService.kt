package com.example.constanta.data.network


import com.example.constanta.domain.models.FilmsResponse
import retrofit2.Response
import retrofit2.http.GET

interface FilmsApiService {
    @GET("main/films.json")
    suspend fun getFilms(): Response<FilmsResponse>
}