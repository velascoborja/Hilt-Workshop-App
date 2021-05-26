package com.gigigo.hiltapp.features.main.di

import com.gigigo.hiltapp.features.main.RandomInjectableClass
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
class MainActivityModule {

    @Provides
    @ActivityScoped
    fun provideRandomClass(): RandomInjectableClass = RandomInjectableClass()

}