package com.revo.listviewactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailMovie : AppCompatActivity() {
    private lateinit var txtDetailMovie: TextView
    private lateinit var  imgDetailMoive: ImageView
    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_movie)
        txtDetailMovie = findViewById(R.id.txtDetailMovie)
        imgDetailMoive = findViewById(R.id.imgDetailMovie)
        btnBack = findViewById(R.id.btnBack)

        //get data dari intent
        val detailTeks = intent.getStringExtra("nama")
        val detailImg = intent.getIntExtra("image", 0)

        //set data ke widget
        txtDetailMovie.setText(detailTeks)
        imgDetailMoive.setImageResource(detailImg)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack.setOnClickListener {
            val intent = Intent(this,Movie::class.java)
            startActivity(intent)
        }
    }
}