package com.gigigo.hiltapp.features.popularmovies.di

import android.content.Context
import com.gigigo.hiltapp.di.AppComponent
import com.gigigo.hiltapp.features.main.di.ActivityScope
import com.gigigo.hiltapp.features.main.di.MainActivityComponent
import com.gigigo.hiltapp.features.popularmovies.ui.PopularMoviesFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class], modules = [MoviesModule::class])
interface MoviesComponent {

    fun inject(moviesFragment: PopularMoviesFragment)

    val context: Context
}