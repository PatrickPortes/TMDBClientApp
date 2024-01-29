package com.example.tmdbclientapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclientapp.data.model.tvshow.TvShow

@Dao
interface TvShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(movies: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShow()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShow(): List<TvShow>

}