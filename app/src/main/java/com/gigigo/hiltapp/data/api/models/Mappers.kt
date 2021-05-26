package com.gigigo.hiltapp.data.api.models

import com.gigigo.hiltapp.BuildConfig
import com.gigigo.hiltapp.domain.models.Movie

private const val ImagesUrl = "https://image.tmdb.org/t/p/original"

fun MovieData.toDomain() = Movie(
    title = original_title.orEmpty(),
    description = overview.orEmpty(),
    imageUrl = "$ImagesUrl${poster_path.orEmpty()}"
)