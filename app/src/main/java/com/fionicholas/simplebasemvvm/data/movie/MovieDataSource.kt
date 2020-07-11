package com.fionicholas.simplebasemvvm.data.movie

import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import io.reactivex.Flowable

interface MovieDataSource {
    fun getPopularMovie(): Flowable<MovieResponse>
}