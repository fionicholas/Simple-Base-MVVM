package com.fionicholas.simplebasemvvm.ui.movie

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.remote.response.Movie
import com.fionicholas.simplebasemvvm.base.BaseViewModel
import io.reactivex.schedulers.Schedulers

class MovieViewModel @ViewModelInject constructor(private val repository: MovieDataSource): BaseViewModel() {

    private val _movies = MutableLiveData<List<Movie>>().apply { value = emptyList() }
    val movies: LiveData<List<Movie>> = _movies

    private val _isViewLoading= MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError= MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    fun loadMovies(){

        subscribe(repository.getPopularMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .doOnSubscribe { _isViewLoading.postValue(true) }
            .doOnError {
                _isViewLoading.postValue(false)
                _onMessageError.value = it}
            .subscribe {
                _isViewLoading.postValue(false)
                _movies.postValue(it.results)
            })

        repository.getPopularMovie()
    }

}