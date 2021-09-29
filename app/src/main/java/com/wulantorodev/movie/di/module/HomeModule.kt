package com.wulantorodev.movie.di.module

import androidx.lifecycle.ViewModel
import com.wulantorodev.movie.data.HomeDataSource
import com.wulantorodev.movie.di.scope.ViewMOdelKey
import com.wulantorodev.movie.presentation.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import retrofit2.Retrofit


@Module

abstract class HomeModule {



    /*********************MVP*******************/
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit) : HomeDataSource =
            retrofit.create(HomeDataSource::class.java)

    }

    @Binds
    @IntoMap
    @ViewMOdelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}