package com.wulantorodev.movie.presentation

import com.wulantorodev.movie.Result

interface HomeViewModelCallback {

    fun onSuccess(results: List<Result>)
    fun onError(error : Throwable)
}