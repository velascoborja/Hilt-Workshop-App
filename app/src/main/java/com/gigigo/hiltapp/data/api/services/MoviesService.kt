package com.gigigo.hiltapp.data.api.services

import com.gigigo.hiltapp.data.api.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MoviesService {

    @GET("movie/popular")
    fun getPopularMovies(): Call<MovieResponse>

}