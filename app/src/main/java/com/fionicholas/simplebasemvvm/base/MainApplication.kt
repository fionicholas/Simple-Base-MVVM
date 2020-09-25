package com.fionicholas.simplebasemvvm.base

import com.fionicholas.simplebasemvvm.di.dbModule
import com.fionicholas.simplebasemvvm.di.movieModule
import org.koin.core.module.Module

class MainApplication : BaseApplication() {

    override fun getDefinedModules(): List<Module> {
        return listOf(
            dbModule,
            movieModule
        )
    }
}