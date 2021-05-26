package com.gigigo.hiltapp.features.popularmovies.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gigigo.hiltapp.databinding.ItemMovieBinding
import com.gigigo.hiltapp.domain.models.Movie
import com.gigigo.hiltapp.util.ImageLoader

class MoviesAdapter(private val imageLoader: ImageLoader) :
    ListAdapter<Movie, MovieViewHolder>(DefaultItemCallback<Movie>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)

        with(holder.binding) {
            title.text = movie.title
            description.text = movie.description
            imageLoader.load(url = movie.imageUrl, into = imageView)
        }
    }
}

class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
