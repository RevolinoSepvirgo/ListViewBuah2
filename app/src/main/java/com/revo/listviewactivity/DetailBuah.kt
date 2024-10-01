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

class DetailBuah : AppCompatActivity() {
    private lateinit var txtDetailBuah: TextView
    private lateinit var  imgDetailBuah: ImageView
    private lateinit var txtdetailLokasi : TextView
    private lateinit var txtdetailDeskripsi : TextView
    private lateinit var btnBack : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_buah)

        txtDetailBuah = findViewById(R.id.txtDetailBuah)
        imgDetailBuah = findViewById(R.id.imgDetailBuah)
        txtdetailLokasi = findViewById(R.id.txtdetailLokasi)
        txtdetailDeskripsi = findViewById(R.id.txtdetailDeskripsi)

        btnBack = findViewById(R.id.btnBack)

        //get data dari intent
        val detailTeks = intent.getStringExtra("nama")
        val detailImg = intent.getIntExtra("image",0)
        val detailLokasi = intent.getStringExtra("lokasi")
        val detailDeskripsi = intent.getStringExtra("deskripsi")

        //set data ke widget
        txtDetailBuah.setText(detailTeks)
        imgDetailBuah.setImageResource(detailImg)
        txtdetailLokasi.setText(detailLokasi)
        txtdetailDeskripsi.setText(detailDeskripsi)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnBack.setOnClickListener {
            val intent = Intent(this, RecycleBuahActivity::class.java)
            startActivity(intent)

        }
    }
}