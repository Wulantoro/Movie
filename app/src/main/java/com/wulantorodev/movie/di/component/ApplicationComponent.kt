package com.wulantorodev.movie.di.component

import com.wulantorodev.movie.BelajarApp
import com.wulantorodev.movie.di.builder.ActivityBuilder
import com.wulantorodev.movie.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<BelajarApp>