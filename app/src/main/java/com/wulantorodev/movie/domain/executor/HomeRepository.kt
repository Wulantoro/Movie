package com.wulantorodev.movie.domain.executor

import io.reactivex.Single

interface HomeRepository {
    fun discoverMovie(param: HomeParam): Single<HomeEntity>
}