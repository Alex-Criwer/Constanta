package com.example.constanta.presentation.helpers

import com.example.constanta.domain.models.Film

interface FilmClickListener {
    fun onFilmIconClick(film: Film)
}