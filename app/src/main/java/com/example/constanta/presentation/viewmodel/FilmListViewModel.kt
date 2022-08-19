package com.example.constanta.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constanta.domain.models.Film
import com.example.constanta.domain.usecases.GetAllFilmsUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

class FilmListViewModel(
    private val getAllFilmsUseCase: GetAllFilmsUseCase
): ViewModel() {
    private val errorHandler = CoroutineExceptionHandler { coroutineContext, error ->
        Timber.d("error in FilmListViewModel is ${error.message}")
    }

    private var _filmListMutableLiveData = MutableLiveData<List<Film>>()
    val filmListLiveData: LiveData<List<Film>> = _filmListMutableLiveData

    fun getAllFilms() {
        viewModelScope.launch(errorHandler) {
            withContext(Dispatchers.IO) {
                val response = getAllFilmsUseCase.execute()
                if (response.isSuccessful){
                    val items = response.body()!!.items.sortedByDescending {it.releaseYear}
                    _filmListMutableLiveData.postValue(items)
                } else {
                    Timber.d("error ${response.code()}")
                }
            }
        }
    }
}