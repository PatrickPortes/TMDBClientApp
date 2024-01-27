package com.example.tmdbclientapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tmdbclientapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startingComponents()
    }

    private fun startingComponents() {
        //TODO("Not yet implemented")
    }
}