package com.example.madlevel6task2.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.madlevel6task2.adapter.MovieAdapter
import com.example.madlevel6task2.databinding.FragmentOverviewBinding
import com.example.madlevel6task2.model.Movie
import com.example.madlevel6task2.vm.MoviesViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OverviewFragment : Fragment() {

    private val vm: MoviesViewModel by activityViewModels()
    private val moviesList = mutableListOf<Movie>()
    private lateinit var binding: FragmentOverviewBinding
    private val moviesAdapter = MovieAdapter(moviesList)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOverviewBinding.inflate(inflater)

        binding.rvMovies.adapter = moviesAdapter
        binding.rvMovies.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

        binding.btnSubmit.setOnClickListener(::handleOnSubmit)

        observeMovies()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun observeMovies() {
        vm.moviesList.observe(viewLifecycleOwner) { moviesList ->
            this.moviesList.clear()
            this.moviesList.addAll(moviesList)
            moviesAdapter.notifyDataSetChanged()
        }
    }

    private fun handleOnSubmit(view: View) {
        val yearInput = binding.inputYear.text!!.toString().toInt()
        vm.fetchMovies(yearInput, 1)
    }
}