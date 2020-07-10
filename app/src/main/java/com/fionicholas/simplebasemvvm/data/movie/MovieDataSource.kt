package com.fionicholas.simplebasemvvm.data.movie

import com.fionicholas.simplebasemvvm.utils.OperationCallback

interface MovieDataSource {

    fun retrieveMovie(callback: OperationCallback)
    fun cancel()

}