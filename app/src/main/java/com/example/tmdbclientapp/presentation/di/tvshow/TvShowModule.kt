package com.example.tmdbclientapp.presentation.di.tvshow

import com.example.tmdbclientapp.domain.usecase.GetTvShowUseCase
import com.example.tmdbclientapp.domain.usecase.UpdateTvShowUseCase
import com.example.tmdbclientapp.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowUseCase,
        updateTvShowsUseCase: UpdateTvShowUseCase
    ) : TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}