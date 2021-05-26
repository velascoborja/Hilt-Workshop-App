package com.gigigo.hiltapp.features.main.di

import com.gigigo.hiltapp.features.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideString() = "Test"

}