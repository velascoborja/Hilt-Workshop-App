package com.gigigo.hiltapp.features.popularmovies.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gigigo.hiltapp.databinding.FragmentMoviesBinding
import com.gigigo.hiltapp.features.popularmovies.presentation.PopularMoviesViewModel
import com.gigigo.hiltapp.util.ImageLoader
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {

    @Inject
    lateinit var imageLoader: ImageLoader

    private val viewModel: PopularMoviesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentMoviesBinding.inflate(inflater, container, false).also { binding ->

        val moviesAdapter = MoviesAdapter(imageLoader)
        binding.list.layoutManager = LinearLayoutManager(requireContext())
        binding.list.adapter = moviesAdapter

        with(viewModel) {
            load()
            movies.observe(viewLifecycleOwner) { items -> moviesAdapter.submitList(items) }
        }
    }.root

    companion object {
        fun newInstance() = PopularMoviesFragment()
    }
}