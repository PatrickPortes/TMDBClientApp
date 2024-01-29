package com.example.tmdbclientapp.data.model.movie


import com.example.tmdbclientapp.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)