package com.gigigo.hiltapp.data.repository

import com.gigigo.hiltapp.data.api.MoviesApiDataSource
import com.gigigo.hiltapp.domain.models.Movie
import com.gigigo.hiltapp.domain.repository.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApiDataSource: MoviesApiDataSource
) : MoviesRepository {

    override suspend fun getPopularMovies(): List<Movie> = moviesApiDataSource.getPopularMovies()
}