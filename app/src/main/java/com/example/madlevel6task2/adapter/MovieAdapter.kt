package com.example.madlevel6task2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.madlevel6task2.R
import com.example.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(
    private val moviesList: List<Movie>,
    private val onClickHandler: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { onClickHandler(moviesList[adapterPosition]) }
        }

        fun databind() {
            val movie = moviesList[adapterPosition]

            Glide.with(context).load(movie.getPosterUrl()).into(itemView.iv_thumbnail)

            itemView.tv_rank.text =
                context.getString(R.string.item_movie_rank_text, adapterPosition + 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.databind()

    override fun getItemCount() = moviesList.size
}