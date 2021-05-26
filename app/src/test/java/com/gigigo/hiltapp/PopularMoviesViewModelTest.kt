package com.gigigo.hiltapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gigigo.hiltapp.domain.models.Movie
import com.gigigo.hiltapp.features.popularmovies.presentation.PopularMoviesViewModel
import com.nhaarman.mockitokotlin2.*
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PopularMoviesViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    private val movies = (0..5).map {
        Movie(
            title = "Title $it",
            description = "Description $it",
            imageUrl = "www.google.es $it"
        )
    }

    @Test
    fun `WHEN popular movies are requested THEN view is notified`() {
        val viewModel = PopularMoviesViewModel(
            getPopularMoviesUseCase = mock { onBlocking { invoke() } doReturn movies }
        )

        val moviesObserver = mock<Observer<List<Movie>>>()
        val moviesCaptor = argumentCaptor<List<Movie>>()
        viewModel.movies.observeForever(moviesObserver)
        viewModel.load()

        verify(moviesObserver, atLeastOnce()).onChanged(moviesCaptor.capture())
        moviesCaptor.run {
            Assert.assertTrue(lastValue.isNotEmpty())
        }
    }
}