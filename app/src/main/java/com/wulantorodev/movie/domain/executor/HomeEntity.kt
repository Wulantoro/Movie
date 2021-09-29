package com.wulantorodev.movie.domain.executor

import com.wulantorodev.movie.Result

data class HomeEntity (
    val page : Long,
    val totalPages: Long,
    val results: MutableList<Result>
        ) {
    data class Result(
        val title : String,
        val overview : String
    )
}
