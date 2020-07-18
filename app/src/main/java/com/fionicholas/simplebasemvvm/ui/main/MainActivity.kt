package com.fionicholas.simplebasemvvm.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fionicholas.simplebasemvvm.R
import com.fionicholas.simplebasemvvm.ui.movie.MovieFragment
import com.fionicholas.simplebasemvvm.utils.replaceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(R.id.frameMain, MovieFragment.newInstance(), false )
    }
}