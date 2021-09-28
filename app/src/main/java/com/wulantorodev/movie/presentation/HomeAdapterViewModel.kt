package com.wulantorodev.movie.presentation

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.wulantorodev.movie.Result

class HomeAdapterViewModel(result: Result) : BaseObservable() {

    val title: String = result.title
    @Bindable get

    val overview: String = result.overview
    @Bindable get
}