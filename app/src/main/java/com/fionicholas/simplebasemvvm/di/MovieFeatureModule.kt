package com.fionicholas.simplebasemvvm.di

import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.MovieRepository
import com.fionicholas.simplebasemvvm.data.movie.remote.MovieApiInterface
import com.fionicholas.simplebasemvvm.utils.Network
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.create
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@dagger.Module
object MovieFeatureModule {

    @Singleton
    @Provides
    fun provideNetworkBuilder(): MovieApiInterface {
        return Network.builder().create()
    }

    @Singleton
    @Provides
    fun provideMovieRepository(services: MovieApiInterface): MovieDataSource {
        return MovieRepository(services)
    }
}