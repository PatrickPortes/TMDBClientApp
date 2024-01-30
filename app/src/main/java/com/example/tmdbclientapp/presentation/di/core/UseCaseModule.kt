package com.example.tmdbclientapp.presentation.di.core

import com.example.tmdbclientapp.domain.repository.ArtistsRepository
import com.example.tmdbclientapp.domain.repository.MovieRepository
import com.example.tmdbclientapp.domain.repository.TvShowRepository
import com.example.tmdbclientapp.domain.usecase.GetArtistsUseCase
import com.example.tmdbclientapp.domain.usecase.GetMoviesUseCase
import com.example.tmdbclientapp.domain.usecase.GetTvShowUseCase
import com.example.tmdbclientapp.domain.usecase.UpdateArtistsUseCase
import com.example.tmdbclientapp.domain.usecase.UpdateMoviesUseCase
import com.example.tmdbclientapp.domain.usecase.UpdateTvShowUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository): GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository): UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistsRepository): GetArtistsUseCase {
        return GetArtistsUseCase(artistRepository)
    }
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistsRepository): UpdateArtistsUseCase {
        return UpdateArtistsUseCase(artistRepository)
    }


}