package com.fionicholas.simplebasemvvm.base

import android.app.Application
import com.fionicholas.simplebasemvvm.utils.ContextProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.module.Module

abstract class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ContextProvider.initialize(applicationContext)
    }

}