package com.fionicholas.simplebasemvvm.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.fionicholas.simplebasemvvm.R
import com.fionicholas.simplebasemvvm.data.movie.remote.response.Movie
import kotlinx.android.synthetic.main.fragment_movie.*
import org.koin.android.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() =
            MovieFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private val movieAdapter: MovieAdapter by lazy {
        MovieAdapter {

        }
    }

    private val viewModel: MovieViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        rvMovies.apply {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

        viewModel.loadMovies()
        setupViewModel()

    }

    private fun setupViewModel() {
        viewModel.movies.observe(this, renderMovies)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }


    private val renderMovies = Observer<List<Movie>> {
        Log.v("TAG", "data updated $it")

        movieAdapter.setMovies(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v("TAG", "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        progress_bar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any> {
        Log.v("TAG", "onMessageError $it")

    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v("TAG", "emptyListObserver $it")
    }

}