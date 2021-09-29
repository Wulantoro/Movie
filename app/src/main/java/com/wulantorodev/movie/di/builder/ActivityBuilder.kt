package com.wulantorodev.movie.di.builder

import androidx.lifecycle.ViewModelProvider
import com.wulantorodev.movie.di.factory.ViewModelFactory
import com.wulantorodev.movie.di.module.HomeModule
import com.wulantorodev.movie.di.scope.Presentation
import com.wulantorodev.movie.presentation.HomeActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Binds
    abstract class bindViewModelFactory(factory : ViewModelFactory): ViewModelProvider.Factory

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}