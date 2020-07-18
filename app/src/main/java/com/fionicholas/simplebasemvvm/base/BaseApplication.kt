package com.fionicholas.simplebasemvvm.base

import android.app.Application
import com.fionicholas.simplebasemvvm.utils.ContextProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ContextProvider.initialize(applicationContext)
    }

}