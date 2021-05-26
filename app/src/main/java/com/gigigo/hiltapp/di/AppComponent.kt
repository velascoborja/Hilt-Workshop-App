package com.gigigo.hiltapp.di

import com.gigigo.hiltapp.App
import com.gigigo.hiltapp.data.api.di.NetworkModule
import com.gigigo.hiltapp.domain.di.RepositoriesModule
import com.gigigo.hiltapp.domain.repository.MoviesRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, RepositoriesModule::class])
interface AppComponent {

    fun inject(app: App)

    val moviesRepository: MoviesRepository
}