package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.data.api.TMDBService
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclientapp.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclientapp.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}