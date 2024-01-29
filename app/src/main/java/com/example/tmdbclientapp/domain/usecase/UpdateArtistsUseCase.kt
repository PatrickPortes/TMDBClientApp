package com.example.tmdbclientapp.domain.usecase

import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.domain.repository.ArtistsRepository

class UpdateArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun execute():List<Artist>? = artistsRepository.updateArtists()
}