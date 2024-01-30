package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclientapp.data.repository.artist.datasourceimpl.ArtistCacheDataSourceImpl
import com.example.tmdbclientapp.data.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclientapp.data.repository.movie.datasourceimpl.MovieCacheDataSourceImpl
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclientapp.data.repository.tvshow.datasourceimpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }

}