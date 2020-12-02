package com.example.desafiomarvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImagemFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagem_full)

        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imageFullscreen))

        val imgClose = findViewById<ImageView>(R.id.imgClose)
        imgClose.setOnClickListener {
            onBackPressed()
        }
    }
}