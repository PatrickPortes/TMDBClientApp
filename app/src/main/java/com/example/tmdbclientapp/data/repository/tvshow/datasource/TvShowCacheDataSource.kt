package com.example.tmdbclientapp.data.repository.tvshow.datasource

import com.example.tmdbclientapp.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShow:List<TvShow>)
}