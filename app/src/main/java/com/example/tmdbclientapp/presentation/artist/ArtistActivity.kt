package com.example.tmdbclientapp.presentation.artist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbclientapp.R
import com.example.tmdbclientapp.databinding.ActivityArtistBinding

class ArtistActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArtistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityArtistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startingComponents()
    }

    private fun startingComponents() {
        //TODO("Not yet implemented")
    }
}