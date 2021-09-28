package com.wulantorodev.movie.di.module

import com.wulantorodev.movie.data.HomeDataSource
import com.wulantorodev.movie.presentation.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module

abstract class HomeModule {



    /*********************MVP*******************/
    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit) : HomeDataSource =
            retrofit.create(HomeDataSource::class.java)

        @JvmStatic
        @Provides
        fun providesHomePresenter(
            callback: HomeViewModelCallback,
            dataSource: HomeDataSource
        ) : HomeViewModel = HomeViewModel(callback , dataSource)

    }

    @Binds
    abstract fun bindHomeViewModelCallback(activity: HomeActivity): HomeViewModelCallback
}