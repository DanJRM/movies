package com.danjrosales.movierecyclerview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.danjrosales.adapter.movieAdapter
import com.danjrosales.movierecyclerview.listener.OnItemMovieSelectedListener
import com.danjrosales.movierecyclerview.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),
    OnItemMovieSelectedListener {

    override fun onItemMovieSelected(movie: Movie) {
        Toast.makeText(baseContext, movie.name, Toast.LENGTH_LONG).show()
    }

    //private lateinit var contactsRecyclerView:RecyclerView
    var idContact: Int = 0

    lateinit var movieAdapter: movieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        ) //ReverseLayout: Revertir elementos
        contactsRecyclerView.layoutManager = linearLayoutManager
        contactsRecyclerView.setHasFixedSize(true)

        val contacts = arrayListOf<Movie>(
            Movie(1, "Tiburón 1", "Spilbergo", "Terror",12),
            Movie(2, "Tiburón 2", "Spilgerbo", "Terror", 23),
            Movie(2, "Tiburón 3", "Spilgerbo", "Terror", 23)
        )

        movieAdapter = movieAdapter(contacts, baseContext)


        movieAdapter.setOnItemContactSelectedListener(this)
        contactsRecyclerView.adapter = movieAdapter

        /* fab.setOnClickListener { view ->
           /*  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 .setAction("Action", null).show()*/
             movieAdapter.addContact(Contact(11,"Ricardo","Moreno","54442234"),2)
         }*/


        /* R.id.action_add.setOnClickListener { view ->
              movieAdapter.addContact(Contact(11,"Ricardo","Moreno","54442234"),2)
          }*/


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_add -> {
                add()
                return true
            }
            R.id.action_remove -> {
                remove()
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }

    fun add(){
        movieAdapter.addContact(Movie(10,"Tiburon 4","Spilbergo","Terror", 2),2)
    }

    fun remove(){
        movieAdapter.removeContact(1)
    }
}