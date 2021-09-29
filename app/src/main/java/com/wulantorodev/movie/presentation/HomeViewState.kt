package com.wulantorodev.movie.presentation

import com.wulantorodev.movie.HomeResponse

sealed class HomeViewState {
    object Loading : HomeViewState()

    data class Success(val response: HomeResponse) : HomeViewState()
    data class Error(val error: Throwable) : HomeViewState()
}