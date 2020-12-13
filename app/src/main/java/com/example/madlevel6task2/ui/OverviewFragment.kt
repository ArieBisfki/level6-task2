package com.example.madlevel6task2.ui

import android.graphics.Rect
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel6task2.R
import com.example.madlevel6task2.adapter.MovieAdapter
import com.example.madlevel6task2.databinding.FragmentOverviewBinding
import com.example.madlevel6task2.model.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OverviewFragment : Fragment() {

    private lateinit var binding: FragmentOverviewBinding
    private val moviesAdapter = MovieAdapter(listOf(
        Movie(
            adult = false,
            backdropPath = "bibo.jpg",
            genreIds = listOf(1, 2, 3),
            id = 120,
            originalTitle = "Babo",
            overview = "NO",
            popularity = 500.0,
            posterPath = "zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            releaseDateString = "2019-12-12",
            title = "Bibo",
            video = false,
            voteAverage = 200.0,
            voteCount = 100
        ),
        Movie(
            adult = false,
            backdropPath = "bibo.jpg",
            genreIds = listOf(1, 2, 3),
            id = 120,
            originalTitle = "Babo",
            overview = "NO",
            popularity = 500.0,
            posterPath = "zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            releaseDateString = "2019-12-12",
            title = "Bibo",
            video = false,
            voteAverage = 200.0,
            voteCount = 100
        ),
        Movie(
            adult = false,
            backdropPath = "bibo.jpg",
            genreIds = listOf(1, 2, 3),
            id = 120,
            originalTitle = "Babo",
            overview = "NO",
            popularity = 500.0,
            posterPath = "zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            releaseDateString = "2019-12-12",
            title = "Bibo",
            video = false,
            voteAverage = 200.0,
            voteCount = 100
        ),
        Movie(
            adult = false,
            backdropPath = "bibo.jpg",
            genreIds = listOf(1, 2, 3),
            id = 120,
            originalTitle = "Babo",
            overview = "NO",
            popularity = 500.0,
            posterPath = "zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            releaseDateString = "2019-12-12",
            title = "Bibo",
            video = false,
            voteAverage = 200.0,
            voteCount = 100
        ),
        Movie(
            adult = false,
            backdropPath = "bibo.jpg",
            genreIds = listOf(1, 2, 3),
            id = 120,
            originalTitle = "Babo",
            overview = "NO",
            popularity = 500.0,
            posterPath = "zoeKREZ2IdAUnXISYCS0E6H5BVh.jpg",
            releaseDateString = "2019-12-12",
            title = "Bibo",
            video = false,
            voteAverage = 200.0,
            voteCount = 100
        )
    ))

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)

        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}