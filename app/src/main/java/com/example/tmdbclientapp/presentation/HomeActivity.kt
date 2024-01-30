package com.example.tmdbclientapp.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tmdbclientapp.databinding.ActivityHomeBinding
import com.example.tmdbclientapp.presentation.artist.ArtistActivity
import com.example.tmdbclientapp.presentation.movie.MovieActivity
import com.example.tmdbclientapp.presentation.tvshow.TvShowActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var btMovies: Button
    private lateinit var btTvShows: Button
    private lateinit var btArtists: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startingComponents()

        btMovies.setOnClickListener {
            startActivity(Intent(this, MovieActivity::class.java))
        }
        btTvShows.setOnClickListener {
            startActivity(Intent(this, TvShowActivity::class.java))
        }
        btArtists.setOnClickListener {
            startActivity(Intent(this, ArtistActivity::class.java))
        }
    }

    private fun startingComponents() {
        btMovies = binding.btMovies
        btTvShows = binding.btTvShows
        btArtists = binding.btArtists
    }
}