package com.wulantorodev.movie.di.builder

import com.wulantorodev.movie.di.module.HomeModule
import com.wulantorodev.movie.di.scope.Presentation
import com.wulantorodev.movie.presentation.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}