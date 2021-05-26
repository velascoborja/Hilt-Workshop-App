package com.gigigo.hiltapp.domain

import com.gigigo.hiltapp.domain.models.Movie
import com.gigigo.hiltapp.domain.repository.MoviesRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository
) {

    suspend operator fun invoke(): List<Movie> = moviesRepository.getPopularMovies()

}