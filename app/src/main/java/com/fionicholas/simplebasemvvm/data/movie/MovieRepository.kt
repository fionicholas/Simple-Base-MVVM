package com.fionicholas.simplebasemvvm.data.movie

import com.fionicholas.simplebasemvvm.data.movie.remote.MovieApiInterface
import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import io.reactivex.Observable

class MovieRepository(private val services: MovieApiInterface) :
    MovieDataSource {

    override fun getPopularMovie(): Observable<MovieResponse> {
        return services.getPopularMovie()
    }

}