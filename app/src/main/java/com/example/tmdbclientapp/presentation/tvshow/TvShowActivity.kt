package com.example.tmdbclientapp.presentation.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tmdbclientapp.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startingComponents()
    }

    private fun startingComponents() {
        //TODO("Not yet implemented")
    }
}