package com.example.constanta.di

import com.example.constanta.presentation.viewmodel.FilmListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        FilmListViewModel(getAllFilmsUseCase = get())
    }
}