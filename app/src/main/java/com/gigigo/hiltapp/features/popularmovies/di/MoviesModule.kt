package com.gigigo.hiltapp.features.popularmovies.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class MoviesModule(private val context: Context) {

    @FragmentScope
    @Provides
    fun provideContext() = context
}