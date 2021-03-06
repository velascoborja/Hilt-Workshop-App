package com.gigigo.hiltapp.features.popularmovies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gigigo.hiltapp.domain.GetPopularMoviesUseCase
import com.gigigo.hiltapp.domain.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase
) : ViewModel() {

    val movies = MutableLiveData<List<Movie>>()

    fun load() {
        viewModelScope.launch {
            val popularMovies = getPopularMoviesUseCase()
            movies.value = popularMovies
        }
    }
}