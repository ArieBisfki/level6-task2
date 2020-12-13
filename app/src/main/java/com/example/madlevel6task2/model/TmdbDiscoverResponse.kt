package com.example.madlevel6task2.model

import com.google.gson.annotations.SerializedName

data class TmdbDiscoverResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<Movie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)