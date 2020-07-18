package com.fionicholas.simplebasemvvm.data.movie

import android.util.Log
import com.fionicholas.simplebasemvvm.BuildConfig.API_KEY
import com.fionicholas.simplebasemvvm.data.movie.remote.MovieApi
import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieResponse
import com.fionicholas.simplebasemvvm.utils.OperationCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository :
    MovieDataSource {

    private var call: Call<MovieResponse>? = null

    override fun retrieveMovie(callback: OperationCallback) {

        call = MovieApi.build()
            ?.movies(API_KEY, "en-US", "1")
        call?.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                response.body()?.let {
                    if (response.isSuccessful) {
                        Log.v("TAG", "data ${it.results}")
                        callback.onSuccess(it.results)
                    } else {
                        callback.onError("Error")
                    }
                }
            }
        })
    }

    override fun cancel() {
        call?.cancel()
    }

}