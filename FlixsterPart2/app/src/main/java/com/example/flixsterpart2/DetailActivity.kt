package com.example.flixsterpart2

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var movieImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        movieImageView = findViewById(R.id.movieImage)
        titleTextView = findViewById(R.id.movieTitle)

        // TODO: Get the extra from the Intent
        val movie = intent.getStringExtra("MOVIE_EXTRA") as Movie

        // TODO: Set the title, byline, and abstract information from the movie
        titleTextView.text = movie.title

        // TODO: Load the media image
        Glide.with(this)
            .load(movie.poster_path)
            .into(movieImageView)
    }
}