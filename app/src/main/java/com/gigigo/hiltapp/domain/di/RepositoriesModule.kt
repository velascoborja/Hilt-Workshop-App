package com.gigigo.hiltapp.domain.di

import com.gigigo.hiltapp.data.repository.MoviesRepositoryImpl
import com.gigigo.hiltapp.domain.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoriesModule {

    @Binds
    @Singleton
    fun bindMoviesRepository(impl: MoviesRepositoryImpl): MoviesRepository

}