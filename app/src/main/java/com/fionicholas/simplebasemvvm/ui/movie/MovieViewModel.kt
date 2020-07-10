package com.fionicholas.simplebasemvvm.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fionicholas.simplebasemvvm.data.movie.MovieDataSource
import com.fionicholas.simplebasemvvm.data.movie.remote.response.Movie
import com.fionicholas.simplebasemvvm.utils.OperationCallback

class MovieViewModel (private val repository: MovieDataSource): ViewModel() {

    private val _movies = MutableLiveData<List<Movie>>().apply { value = emptyList() }
    val movies: LiveData<List<Movie>> = _movies

    private val _isViewLoading= MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    private val _onMessageError= MutableLiveData<Any>()
    val onMessageError: LiveData<Any> = _onMessageError

    private val _isEmptyList= MutableLiveData<Boolean>()
    val isEmptyList: LiveData<Boolean> = _isEmptyList


    fun loadMovies(){

        _isViewLoading.postValue(true)

        repository.retrieveMovie(object: OperationCallback {
            override fun onError(obj: Any?) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue( obj)
            }

            override fun onSuccess(obj: Any?) {
                _isViewLoading.postValue(false)

                if(obj!=null && obj is List<*>){
                    if(obj.isEmpty()){
                        _isEmptyList.postValue(true)
                    }else{
                        _movies.value= obj as List<Movie>?
                    }
                }
            }
        })
    }

}