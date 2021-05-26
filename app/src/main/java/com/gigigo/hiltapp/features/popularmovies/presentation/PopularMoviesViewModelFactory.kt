package com.gigigo.hiltapp.features.popularmovies.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gigigo.hiltapp.domain.GetPopularMoviesUseCase
import javax.inject.Inject

class PopularMoviesViewModelFactory @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        PopularMoviesViewModel(getPopularMoviesUseCase) as T
}