package com.wulantorodev.movie.domain

import com.wulantorodev.movie.domain.common.UseCase
import com.wulantorodev.movie.domain.executor.*
import io.reactivex.Single

class HomeUsecase(
    private val repository: HomeRepository,
    executor: JobExecutor,
    thread: UIThread
) : UseCase<HomeEntity, HomeParam>(executor, thread) {
    override fun buildUsecaseObservable(params: HomeParam): Single<HomeEntity> {
        return repository.discoverMovie(params)
    }
}