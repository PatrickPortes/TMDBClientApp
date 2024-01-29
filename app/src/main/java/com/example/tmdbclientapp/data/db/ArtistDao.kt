package com.example.tmdbclientapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientapp.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(movies: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist(): List<Artist>

}