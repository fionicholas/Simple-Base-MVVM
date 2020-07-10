package com.fionicholas.simplebasemvvm.data.movie.remote

import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServicesApiInterface {

    @GET("movie/popular")
    fun movies(@Query("api_key") apiKey: String, @Query("language") language: String, @Query("page") page: String): Call<MovieResponse>

}