package com.gigigo.hiltapp.data.api

import com.gigigo.hiltapp.data.api.models.toDomain
import com.gigigo.hiltapp.data.api.services.MoviesService
import com.gigigo.hiltapp.domain.models.Movie
import retrofit2.await
import javax.inject.Inject

class MoviesApiDataSource @Inject constructor(
    private val moviesService: MoviesService
) {
    suspend fun getPopularMovies(): List<Movie> = runCatching {
        moviesService.getPopularMovies().await().results.orEmpty()
    }.getOrDefault(emptyList()).map { movieData -> movieData.toDomain() }
}