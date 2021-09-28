package com.wulantorodev.movie.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.wulantorodev.movie.BR
import com.wulantorodev.movie.data.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.security.auth.callback.Callback

class HomeViewModel(
    private val callback: HomeViewModelCallback,
    private val dataSource: HomeDataSource
) : BaseObservable(), HomeView {
    var progressBarVisibility: Int = View.GONE
    @Bindable get

    private val disposable : CompositeDisposable = CompositeDisposable()

    override fun discoverMovie() {
        progressBarVisibility = View.VISIBLE
        notifyPropertyChanged(BR.progressBarVisibility)



        dataSource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onSuccess(response.results)
            }, {error ->
                progressBarVisibility = View.GONE
                notifyPropertyChanged(BR.progressBarVisibility)
                callback.onError(error)
            }).addTo(disposable)
    }

    override fun onDetach() {
        disposable.clear()
    }
}