package com.wulantorodev.movie.presentation

import com.wulantorodev.movie.HomeResponse
import com.wulantorodev.movie.di.module.NetworkModule
import com.wulantorodev.movie.data.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeView,
    private val dataSource: HomeDataSource) {

    private val disposables: CompositeDisposable = CompositeDisposable()

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
        disposables.clear()
    }


}