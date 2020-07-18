package com.fionicholas.simplebasemvvm.data.movie.remote

import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("movie/popular")
    fun getPopularMovie(): Flowable<MovieResponse>

}