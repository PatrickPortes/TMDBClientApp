package com.example.tmdbclientapp.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclientapp.domain.usecase.GetTvShowUseCase
import com.example.tmdbclientapp.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }

}