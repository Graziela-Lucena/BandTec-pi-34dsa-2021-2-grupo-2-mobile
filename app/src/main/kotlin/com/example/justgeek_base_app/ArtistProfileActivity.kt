package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.delegate.viewProvider
import com.example.justgeek_base_app.adapter.GalleryAdapter
import com.example.justgeek_base_app.viewmodel.ArtistViewModel
import com.squareup.picasso.Picasso
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistProfileActivity : AppCompatActivity(R.layout.activity_artist_profile) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val artistViewModel: ArtistViewModel by viewModel()

        val image = findViewById<ImageView>(R.id.photo_artist)
        val name = findViewById<TextView>(R.id.name_artist)
        val bio = findViewById<TextView>(R.id.bio_artist)

        val gallery = findViewById<RecyclerView>(R.id.container_arts)

        artistViewModel.getArtist(1).observe(this) {
            data {
                Picasso.get().load(it.imagemPerfil).into(image)
                name.text = it.apelido
                bio.text = it.biografia
                gallery.adapter = GalleryAdapter(it.artes)
            }
        }

        gallery.layoutManager = GridLayoutManager(this, 2)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val similarArtists = ArtistsSimilarFragment()
        fragmentTransaction.add(R.id.fragment_others_artists, similarArtists)
        fragmentTransaction.commit()
    }
}