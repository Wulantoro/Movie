package com.wulantorodev.movie.presentation

import com.wulantorodev.movie.Result

interface HomeView {

    fun discoverMovie()
    fun onDetach()

    /***********************MVP************************/
//    fun onShowLoading()
//    fun onHideLoading()
//    fun onResponse(results: List<Result>)
//    fun onFailure(error: Throwable)
}