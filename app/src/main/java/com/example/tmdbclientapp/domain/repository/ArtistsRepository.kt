package com.example.tmdbclientapp.domain.repository

import com.example.tmdbclientapp.data.model.artist.Artist

interface ArtistsRepository {

    suspend fun getArtists():List<Artist>?
    suspend fun updateArtists():List<Artist>?

}