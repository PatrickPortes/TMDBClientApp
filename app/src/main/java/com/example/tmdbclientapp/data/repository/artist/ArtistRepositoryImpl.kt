package com.example.tmdbclientapp.data.repository.artist

import android.util.Log
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclientapp.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclientapp.domain.repository.ArtistsRepository

class ArtistRepositoryImpl (
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistsRepository{

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null){
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist>{
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}