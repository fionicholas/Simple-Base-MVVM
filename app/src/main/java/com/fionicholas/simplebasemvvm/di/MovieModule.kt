package com.fionicholas.simplebasemvvm.di

import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.MovieRepository
import com.fionicholas.simplebasemvvm.ui.movie.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    single<MovieDataSource> { MovieRepository() }

    viewModel { MovieViewModel(get()) }
}