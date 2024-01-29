package com.example.tmdbclientapp.data.repository.tvshow.datasourceimpl

import com.example.tmdbclientapp.data.db.MovieDao
import com.example.tmdbclientapp.data.db.TvShowDao
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowDao.getTvShow()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShow()
        }
    }
}