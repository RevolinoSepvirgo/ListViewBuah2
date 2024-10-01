package com.revo.listviewactivity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btnhewan: Button
    private lateinit var btnbuku : Button
    private lateinit var btnbuah : Button
    private lateinit var btnMovie : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        btnhewan = findViewById(R.id.btnhewan)
        btnbuku = findViewById(R.id.btnbuku)
        btnbuah = findViewById(R.id.btnbuah)
        btnMovie = findViewById(R.id.btnMovie)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnhewan.setOnClickListener() {
            val intent = Intent(this@MainActivity, hewan::class.java)
            startActivity(intent)
        }
        btnbuku.setOnClickListener() {
            val intent = Intent(this@MainActivity, RecycleviewAcitivity::class.java)
            startActivity(intent)
        }
        btnbuah.setOnClickListener() {
            val intent = Intent(this@MainActivity, RecycleBuahActivity::class.java)
            startActivity(intent)
        }
        btnMovie.setOnClickListener() {
            val intent = Intent(this@MainActivity,Movie::class.java)
            startActivity(intent)
        }
    }
}