package com.wulantorodev.movie.data

import com.wulantorodev.movie.BuildConfig
import com.wulantorodev.movie.HomeResponse
import io.reactivex.Single

class HomeFactory(private val dataSource: HomeDataSource) {

    fun discoverMovie(page : Long) : Single<HomeResponse> =
        dataSource.discoverMovie(
            apiKey = BuildConfig.API_KEY,
            page = page
        )
}