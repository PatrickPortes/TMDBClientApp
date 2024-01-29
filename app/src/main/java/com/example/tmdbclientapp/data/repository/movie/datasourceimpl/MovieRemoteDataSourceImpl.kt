package com.example.tmdbclientapp.data.repository.movie.datasourceimpl

import com.example.tmdbclientapp.data.api.TMDBService
import com.example.tmdbclientapp.data.model.movie.MovieList
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}