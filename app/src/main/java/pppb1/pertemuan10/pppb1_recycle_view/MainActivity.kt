package pppb1.pertemuan10.pppb1_recycle_view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import pppb1.pertemuan10.pppb1_recycle_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movies = listOf(
            Disaster(R.drawable.venom, "Venom: The Last Dance", "1h 49m", "R13+", "Action", "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Disaster(R.drawable.musyrik, "DOSA MUSYRIK", "1h 32m", "D17+", "Horror", "Lorem ipsum"),
            Disaster(R.drawable.inside_out, "Inside Out 2", "1h 36m", "SU", "Animation", "Disney"),
            Disaster(R.drawable.transformers, "Transformer One", "1h 44m", "R13+", "Action", "Lorem ipsum"),
            Disaster(R.drawable.venom, "Venom: The Last Dance", "1h 49m", "R13+", "Action", "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Disaster(R.drawable.musyrik, "DOSA MUSYRIK", "1h 32m", "D17+", "Horror", "Lorem ipsum"),
        )

        val disasterAdapter = DisasterAdapter(movies) {movie ->
            val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
            intent.putExtra("image", movie.imageResId)
            intent.putExtra("title", movie.title)
            intent.putExtra("genre", movie.genre)
            intent.putExtra("duration", movie.duration)
            intent.putExtra("rate", movie.rate)
            intent.putExtra("description", movie.description) // Add description field in Disaster if necessary
            startActivity(intent)
        }

        with(binding){
            rvDisaster.apply {
                adapter = disasterAdapter
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }
}