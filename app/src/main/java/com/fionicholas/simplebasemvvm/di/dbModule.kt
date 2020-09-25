package com.fionicholas.simplebasemvvm.di

import com.fionicholas.simplebasemvvm.data.AppDatabase
import org.koin.dsl.module

val dbModule = module {

    single { AppDatabase.getAppDatabase(get()) }

}