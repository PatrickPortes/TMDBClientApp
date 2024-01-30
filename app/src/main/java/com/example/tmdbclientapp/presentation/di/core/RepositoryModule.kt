package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.data.repository.artist.ArtistRepositoryImpl
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclientapp.data.repository.movie.MovieRepositoryImpl
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclientapp.data.repository.tvshow.TvShowRepositoryImpl
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclientapp.domain.repository.ArtistsRepository
import com.example.tmdbclientapp.domain.repository.MovieRepository
import com.example.tmdbclientapp.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource,
    ) : MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource,
    ) : TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource,
    ) : ArtistsRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }



}