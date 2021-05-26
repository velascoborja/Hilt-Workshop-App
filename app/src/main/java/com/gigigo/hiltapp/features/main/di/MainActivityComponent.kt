package com.gigigo.hiltapp.features.main.di

import com.gigigo.hiltapp.di.AppComponent
import com.gigigo.hiltapp.features.main.MainActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [AppComponent::class], modules = [MainActivityModule::class])
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)
}