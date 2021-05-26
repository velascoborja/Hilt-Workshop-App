package com.gigigo.hiltapp

import android.app.Application
import com.gigigo.hiltapp.di.AppComponent
import com.gigigo.hiltapp.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)
    }
}