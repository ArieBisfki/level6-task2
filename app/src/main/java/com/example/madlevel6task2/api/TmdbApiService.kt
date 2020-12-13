package com.example.madlevel6task2.api

import com.example.madlevel6task2.BuildConfig
import com.example.madlevel6task2.model.TmdbDiscoverResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApiService {
    @GET("3/discover/movie")
    suspend fun discover(
            @Query("year") year: Int,
            @Query("page") page: Int,
            @Query("sort_by") sortBy: String = "popularity.desc",
            @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
            @Query("language") language: String = "en-US",
            @Query("include_video") includeVideo: Boolean = false,
            @Query("include_adult") includeAdult: Boolean = false
    ): TmdbDiscoverResponse
}