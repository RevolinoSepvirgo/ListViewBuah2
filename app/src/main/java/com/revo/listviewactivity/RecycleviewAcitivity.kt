package com.revo.listviewactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.revo.listviewactivity.adapter.BukuAdapter
import com.revo.listviewactivity.model.ModelBuku

class RecycleviewAcitivity : AppCompatActivity() {

    private lateinit var rv_data : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycleview_acitivity)

        rv_data = findViewById(R.id.rv_data)


        val listBuku = listOf(
            ModelBuku(judul ="Buku Android Kotlin 2024", penerbit = "revolino"),
            ModelBuku(judul ="Siti Nurbaya", penerbit = "Marah Ruslli"),
            ModelBuku(judul ="Ayat-Ayat Cinta", penerbit = "Habiburrahman"),
            ModelBuku(judul ="Dilan 1990", penerbit = "Pidi Baiq"),
            ModelBuku(judul ="Laskar Pelangi", penerbit = "Andrea HIrata"),
        )
        val nBukuAdapter = BukuAdapter(listBuku)
        rv_data.apply {
            layoutManager = LinearLayoutManager(this@RecycleviewAcitivity)
            adapter = nBukuAdapter
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}