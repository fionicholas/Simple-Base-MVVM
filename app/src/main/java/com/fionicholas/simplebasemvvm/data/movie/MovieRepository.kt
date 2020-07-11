package com.fionicholas.simplebasemvvm.data.movie

import com.fionicholas.simplebasemvvm.data.movie.remote.MovieApiInterface
import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import io.reactivex.Flowable
import javax.inject.Inject

open class MovieRepository @Inject constructor(
    private val services: MovieApiInterface
) : MovieDataSource {

    override fun getPopularMovie(): Flowable<MovieResponse> {
        return services.getPopularMovie()
    }

}