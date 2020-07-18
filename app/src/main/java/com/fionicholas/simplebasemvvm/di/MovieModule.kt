package com.fionicholas.simplebasemvvm.di

import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.MovieRepository
import com.fionicholas.simplebasemvvm.data.movie.remote.MovieApiInterface
import com.fionicholas.simplebasemvvm.ui.movie.MovieViewModel
import com.fionicholas.simplebasemvvm.utils.Network
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.create

val movieModule = module {

    single<MovieApiInterface> { Network.builder().create() }

    single<MovieDataSource> { MovieRepository(get()) }

    viewModel { MovieViewModel(get()) }
}