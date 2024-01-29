package com.example.tmdbclientapp.domain.usecase

import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.domain.repository.TvShowRepository

class UpdateTvShowUseCase (private val tvShowRepository: TvShowRepository){
    suspend fun execute():List<TvShow>? = tvShowRepository.updateTvShows()
}