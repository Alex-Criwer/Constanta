package com.example.constanta.domain.usecases


import com.example.constanta.domain.models.FilmsResponse
import com.example.constanta.domain.repository.FilmRepository
import retrofit2.Response

class GetAllFilmsUseCase(private val filmRepository: FilmRepository) {
    suspend fun execute(): Response<FilmsResponse> {
        return filmRepository.getAllFilms()
    }
}