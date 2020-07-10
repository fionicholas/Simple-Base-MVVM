package com.fionicholas.simplebasemvvm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fionicholas.simplebasemvvm.R
import com.fionicholas.simplebasemvvm.ui.movie.MovieFragment
import com.fionicholas.simplebasemvvm.utils.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(R.id.frameMain, MovieFragment.newInstance(), false )
    }
}