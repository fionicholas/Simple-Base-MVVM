package com.fionicholas.simplebasemvvm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fionicholas.simplebasemvvm.base.BaseViewModel
import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.remote.response.MovieItem
import io.reactivex.schedulers.Schedulers

class MovieViewModel(private val repository: MovieDataSource): BaseViewModel() {

    private val _movies = MutableLiveData<List<MovieItem>>().apply { value = emptyList() }
    val movies: LiveData<List<MovieItem>> = _movies

    private val _isViewLoading= MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError= MutableLiveData<String>()
    val onMessageError: LiveData<String> = _onMessageError

    fun loadMovies(){

        subscribe(repository.getPopularMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe { _isViewLoading.postValue(true) }
            .subscribe ({
                _isViewLoading.postValue(false)
                _movies.postValue(it.results)
            },{
                onErrorNetwork(it)
            })
        )

    }

     private fun onErrorNetwork(throwable: Throwable) {
         _isViewLoading.postValue(false)
         _onMessageError.postValue(throwable.message)
    }

}