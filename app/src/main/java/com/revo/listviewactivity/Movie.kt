package com.revo.listviewactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.revo.listviewactivity.adapter.MovieAdapter
import com.revo.listviewactivity.model.MockList
import com.revo.listviewactivity.model.Mocklist1
import com.revo.listviewactivity.model.ModelMovie

class Movie : AppCompatActivity() {
    private lateinit var rv_Movie : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie)

        rv_Movie = findViewById(R.id.rv_movie)


        rv_Movie.layoutManager = GridLayoutManager(this, 2)
        val adapter = MovieAdapter(Mocklist1.getmodel()as ArrayList<ModelMovie> , this)
        rv_Movie.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}