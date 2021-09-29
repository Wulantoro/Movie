package com.wulantorodev.movie.presentation

import androidx.lifecycle.LiveData
import com.wulantorodev.movie.Result
import com.wulantorodev.movie.domain.executor.HomeEntity

interface HomeView {

//    val states: LiveData<HomeViewState>
//    fun discoverMovie()

//    fun discoverMovie()
//    fun onDetach()

    /***********************MVP************************/
    fun onShowLoading()
    fun onHideLoading()

    fun onSuccess(entity: HomeEntity)
    fun onError(error: Throwable)

    fun onPaginationSuccess(entity: HomeEntity)
    fun onPaginationError(error: Throwable)
//    fun onResponse(results: List<Result>)
//    fun onFailure(error: Throwable)
}