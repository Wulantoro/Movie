package com.wulantorodev.movie.presentation

import com.wulantorodev.movie.HomeResponse
import com.wulantorodev.movie.di.module.NetworkModule
import com.wulantorodev.movie.data.HomeDataSource
import com.wulantorodev.movie.domain.HomeUsecase
import com.wulantorodev.movie.domain.common.DefaultObserver
import com.wulantorodev.movie.domain.executor.HomeEntity
import com.wulantorodev.movie.domain.executor.HomeParam
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeView,
    private val uscase: HomeUsecase ) {

//    private val disposables: CompositeDisposable = CompositeDisposable()

    fun discoverMovie() {
        view.onShowLoading()
        uscase.execute(
            DiscoverMovieUsecase(),
            HomeParam()
        )
    }

    fun loadMore(page: Long) {
        uscase.execute(
            LoadMoreUsecase(),
            HomeParam(page = page)
        )
    }

//    fun discoverMovie() {
//        view.onShowLoading()
//
//        dataSource.discoverMovie()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ response ->
//                view.onHideLoading()
//                view.onResponse(response.results)
//            }, {error ->
//                view.onHideLoading()
//                view.onFailure(error)
//            }).addTo(disposables)
//    }

    fun onDetach() {
        uscase.dispose()
    }

    inner class DiscoverMovieUsecase : DefaultObserver<HomeEntity>() {
        override fun onSuccess(entity: HomeEntity) {
            view.onShowLoading()
            view.onSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onHideLoading()
            view.onError(exception)
        }
    }

    inner class LoadMoreUsecase : DefaultObserver<HomeEntity>() {
        override fun onSuccess(entity: HomeEntity) {
            view.onPaginationSuccess(entity)
        }

        override fun onError(exception: Throwable) {
            view.onPaginationError(exception)
        }
    }


}