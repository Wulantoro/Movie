package com.wulantorodev.movie

import com.wulantorodev.movie.di.component.ApplicationComponent
import dagger.android.AndroidInjection.inject
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import com.wulantorodev.movie.di.component.DaggerApplicationComponent
import dagger.internal.InstanceFactory.create
import dagger.internal.ProviderOfLazy.create


class BelajarApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerApplicationComponent.create().apply{
            inject(this@BelajarApp)
        }
    }
}