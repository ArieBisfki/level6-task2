package com.example.madlevel6task2.vm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.madlevel6task2.repository.MoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val moviesRepository = MoviesRepository()

    val moviesList = moviesRepository.moviesList

    fun fetchMovies(year: Int, page: Int) {
        viewModelScope.launch {
            try {
                moviesRepository.fetch(year, page)
            } catch (error: MoviesRepository.MovieFetchError) {
                Log.e("Movie fetching error", error.cause.toString())
            }
        }
    }
}
