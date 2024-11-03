package pppb1.pertemuan10.pppb1_recycle_view

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import pppb1.pertemuan10.pppb1_recycle_view.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve data from Intent
        val title = intent.getStringExtra("title")
        val genre = intent.getStringExtra("genre")
        val duration = intent.getStringExtra("duration")
        val rate = intent.getStringExtra("rate")
        val description = intent.getStringExtra("description")
        val imageResId = intent.getIntExtra("image", 0) // Retrieve the image resource ID

        // Set data to views using binding
        binding.detailTitle.text = title
        binding.detailGenre.text = genre
        binding.movieDuration.text = duration
        binding.movieRate.text = rate
        binding.detailDesc.text = description

        // Set the movie image using the image resource ID
        binding.detailImg.setImageResource(imageResId)

        // Set the back arrow functionality
        binding.detailTv1.setOnClickListener {
            finish() // Close this activity and return to the previous one
        }
    }
}
