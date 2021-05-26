package com.gigigo.hiltapp.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gigigo.hiltapp.R
import com.gigigo.hiltapp.features.popularmovies.ui.PopularMoviesFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var test: String

    @Inject
    lateinit var random: RandomInjectableClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PopularMoviesFragment.newInstance())
            .commit()
    }
}