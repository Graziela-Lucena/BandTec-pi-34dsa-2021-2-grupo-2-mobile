package com.example.justgeek_base_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.GalleryAdapter
import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistProductActivity: AppCompatActivity(R.layout.activity_artist_product_page) {
    val viewModel: ArtistViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val img = findViewById<ImageView>(R.id.image_art)
        val title = findViewById<TextView>(R.id.title)
        val button = findViewById<Button>(R.id.button)
        val info = viewModel.getArtist(1).observe(this) {
           data {
               title.text = resources.getString(R.string.subtitle_description_art, it.apelido)
               recycler.adapter = GalleryAdapter(it.artes) {
                   intent.putExtra("pathArtImage", it)
               }
               Picasso.get().load("path").into(img)
           }
        }
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        button.setOnClickListener {
            startActivity(Intent(this, ArtistFormActivity::class.java))
        }
    }

}