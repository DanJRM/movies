package com.danjrosales.movierecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.danjrosales.movierecyclerview.model.Movie

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movie=intent.extras.getSerializable("movie") as Movie
        Log.d("test","Hola")
    }
}
