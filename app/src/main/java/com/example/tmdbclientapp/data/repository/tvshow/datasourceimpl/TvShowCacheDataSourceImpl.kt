package com.example.tmdbclientapp.data.repository.tvshow.datasourceimpl

import com.example.tmdbclientapp.data.model.movie.Movie
import com.example.tmdbclientapp.data.model.tvshow.TvShow
import com.example.tmdbclientapp.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl: TvShowCacheDataSource {

    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShow: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShow)
    }
}