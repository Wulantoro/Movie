package com.wulantorodev.movie.data

import com.wulantorodev.movie.BuildConfig
import com.wulantorodev.movie.HomeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDataSource {

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Call<HomeResponse>
}