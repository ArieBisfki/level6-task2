package com.example.madlevel6task2.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.madlevel6task2.api.TmdbApi
import com.example.madlevel6task2.api.TmdbApiService
import com.example.madlevel6task2.model.Movie
import kotlinx.coroutines.withTimeout

class MoviesRepository {
    private val tmdbApiService: TmdbApiService = TmdbApi.createApi()

    private val _moviesList: MutableLiveData<List<Movie>> = MutableLiveData()

    val moviesList: LiveData<List<Movie>>
        get() = _moviesList

    suspend fun fetch(year: Int, page: Int)  {
        try {
            //timeout the request after 5 seconds
            val result = withTimeout(5_000) {
                tmdbApiService.discover(year, page)
            }

            _moviesList.value = result.results
        } catch (error: Throwable) {
            throw MovieFetchError("Unable to fetch movies", error)
        }
    }

    class MovieFetchError(message: String, cause: Throwable) : Throwable(message, cause)

}
