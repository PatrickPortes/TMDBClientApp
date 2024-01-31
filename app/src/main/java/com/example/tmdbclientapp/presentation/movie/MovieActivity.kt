package com.example.tmdbclientapp.presentation.movie

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclientapp.R
import com.example.tmdbclientapp.databinding.ActivityMovieBinding
import com.example.tmdbclientapp.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel

    private lateinit var binding: ActivityMovieBinding

    private lateinit var adapter: MovieAdapter

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()

        // Set the appropriate icon color based on the current theme mode
        updateIconColor()
        // Listen for system theme changes and update the icon color accordingly
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }

    private fun initRecyclerView(){
        binding.moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.moviesRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayPopularMovies() {

        binding.moviesProgressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {

            //Log.i("MyTag", it.toString())

            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.moviesProgressBar.visibility = View.GONE
            } else {
                binding.moviesProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }

        })
    }


    // Update Icon Color (Set Tint Color Programmatically):
    @RequiresApi(Build.VERSION_CODES.R)
    private fun updateIconColor(){
        val iconDrawable = ContextCompat.getDrawable(this, R.drawable.baseline_update_24)
        val color = if (resources.configuration.isNightModeActive) {
            ContextCompat.getColor(this, R.color.white) // Night mode, white color
        } else {
            ContextCompat.getColor(this, R.color.black) // Day mode, black color
        }
        iconDrawable?.let {
            val wrappedDrawable = DrawableCompat.wrap(it)
            DrawableCompat.setTint(wrappedDrawable, color)
            supportActionBar?.setHomeAsUpIndicator(wrappedDrawable)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_update -> {

                if (isNetworkConnected(applicationContext)) {
                    updateMovies()
                } else {
                    Toast.makeText(applicationContext,"To Update, Please Connect to the Internet.", Toast.LENGTH_LONG).show()
                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateMovies(){
        binding.moviesProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.moviesProgressBar.visibility = View.GONE
            } else {
                binding.moviesProgressBar.visibility = View.GONE
            }
        })
    }

    private fun isNetworkConnected(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}