package pppb1.pertemuan10.pppb1_recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pppb1.pertemuan10.pppb1_recycle_view.databinding.DisasterItemBinding

class DisasterAdapter (private val movies: List<Disaster>, private val onClick: (Disaster) -> Unit) : RecyclerView.Adapter<DisasterAdapter.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movie_img)
        val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        val movieDuration: TextView = itemView.findViewById(R.id.movie_duration)
        val movieRate: TextView = itemView.findViewById(R.id.movie_rate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.disaster_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieImage.setImageResource(movie.imageResId)
        holder.movieTitle.text = movie.title
        holder.movieDuration.text = movie.duration
        holder.movieRate.text = movie.rate

        holder.itemView.setOnClickListener {
            onClick(movie)
        }
    }



}