package com.gigigo.hiltapp.domain.repository

import com.gigigo.hiltapp.domain.models.Movie

interface MoviesRepository {
    suspend fun getPopularMovies(): List<Movie>
}