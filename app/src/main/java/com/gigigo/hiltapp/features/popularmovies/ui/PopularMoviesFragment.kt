package com.gigigo.hiltapp.features.popularmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigigo.hiltapp.App
import com.gigigo.hiltapp.databinding.FragmentMoviesBinding
import com.gigigo.hiltapp.features.main.MainActivity
import com.gigigo.hiltapp.features.main.di.MainActivityComponent
import com.gigigo.hiltapp.features.popularmovies.di.DaggerMoviesComponent
import com.gigigo.hiltapp.features.popularmovies.di.MoviesModule
import com.gigigo.hiltapp.features.popularmovies.presentation.PopularMoviesViewModel
import com.gigigo.hiltapp.features.popularmovies.presentation.PopularMoviesViewModelFactory
import com.gigigo.hiltapp.util.ImageLoader
import javax.inject.Inject

class PopularMoviesFragment : Fragment() {

    @Inject
    lateinit var imageLoader: ImageLoader

    @Inject
    lateinit var factory: PopularMoviesViewModelFactory

    private val viewModel: PopularMoviesViewModel by viewModels { factory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also { binding ->

        initInjector()

        val moviesAdapter = MoviesAdapter(imageLoader)
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = moviesAdapter

        with(viewModel) {
            load()
            movies.observe(viewLifecycleOwner) { items -> moviesAdapter.submitList(items) }
        }
    }.root

    private fun initInjector() =
        DaggerMoviesComponent
            .builder()
            .appComponent((requireContext().applicationContext as App).appComponent)
            .moviesModule(MoviesModule(requireContext()))
            .build()
            .inject(this)

    companion object {
        fun newInstance() = PopularMoviesFragment()
    }
}