package com.gigigo.hiltapp.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gigigo.hiltapp.App
import com.gigigo.hiltapp.R
import com.gigigo.hiltapp.features.main.di.DaggerMainActivityComponent
import com.gigigo.hiltapp.features.main.di.MainActivityComponent
import com.gigigo.hiltapp.features.main.di.MainActivityModule
import com.gigigo.hiltapp.features.popularmovies.ui.PopularMoviesFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var test: String

    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent
            .builder()
            .appComponent((applicationContext as App).appComponent)
            .mainActivityModule(MainActivityModule(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjector()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PopularMoviesFragment.newInstance())
            .commit()
    }

    private fun initInjector() = activityComponent.inject(this)
}