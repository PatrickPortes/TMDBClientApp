package com.example.tmdbclientapp.data.db

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tmdbclientapp.data.model.artist.Artist
import com.example.tmdbclientapp.data.model.movie.Movie
import com.example.tmdbclientapp.data.model.tvshow.TvShow

@Database(
    entities = [Movie::class,TvShow::class,Artist::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

//    companion object{
//        @Volatile
//        private var INSTANCE : TMDBDatabase? = null
//        @SuppressLint("SuspiciousIndentation")
//        fun getInstance(context: Context):TMDBDatabase{
//            synchronized(this){
//                var instance = INSTANCE
//                if (instance==null){
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        TMDBDatabase::class.java,
//                        "student_data_database"
//                    ).build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }

}