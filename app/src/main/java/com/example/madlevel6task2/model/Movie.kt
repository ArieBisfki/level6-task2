package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Movie(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("genre_ids") val genreIds: List<Int>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDateString: String,
    @SerializedName("title") val title: String,
    @SerializedName("video") val video: Boolean,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("vote_count") val voteCount: Int
) {
    fun getReleaseDate(): GregorianCalendar {
        val (year, month, day) = this.releaseDateString.split('-').map(String::toInt)

        // Gregorian calendar uses indexes for month. Release date returned from Tmdb API does not. So convert month to index.
        return GregorianCalendar(year, month - 1, day)
    }

    fun getBackdropUrl(): String? {
        if (backdropPath == null) return null

        return "$IMAGES_BASE_URL/$backdropPath"
    }

    fun getPosterUrl(): String {
        return "$IMAGES_BASE_URL/$posterPath"
    }

    companion object {
        private const val IMAGES_BASE_URL = "https://image.tmdb.org/t/p/w500"
    }
}
