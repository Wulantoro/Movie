package com.wulantorodev.movie.presentation

import android.view.View
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wulantorodev.movie.BR
import com.wulantorodev.movie.data.HomeDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject
import javax.security.auth.callback.Callback

class HomeViewModel @Inject constructor(
    private val dataSource: HomeDataSource
) : ViewModel(), HomeView {


    private val disposable : CompositeDisposable = CompositeDisposable()
    private val observer :  MutableLiveData<HomeViewState>()

    override val states: LiveData<HomeViewState>
    get() = observer

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



    override fun discoverMovie() {

       dataSource.discoverMovie()
           .map<HomeViewState>(HomeViewState::Success)
           .onErrorReturn(HomeViewState::Error)
           .toFlowable()
           .startWith(HomeViewState.Loading)
           .subscribe(observer::postValue)
           .let(disposable::add)

    }

}