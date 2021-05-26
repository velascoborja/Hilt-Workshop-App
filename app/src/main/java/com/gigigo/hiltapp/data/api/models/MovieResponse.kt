package com.gigigo.hiltapp.data.api.models

data class MovieResponse(
    val results: List<MovieData>?
)

data class MovieData(
    val original_title: String?,
    val overview: String?,
    val poster_path: String?
)
