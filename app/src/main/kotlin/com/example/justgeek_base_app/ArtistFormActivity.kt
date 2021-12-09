package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.example.justgeek_base_app.viewmodel.CartViewModel
import com.google.android.material.chip.ChipGroup
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistFormActivity : AppCompatActivity(R.layout.activity_artist_form) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: CartViewModel by viewModel()
        val btnRequestArtist = findViewById<AppCompatButton>(R.id.button_finish_request_artist)
        btnRequestArtist.setOnClickListener {
            viewModel.addToCart(1, 2, 3, "")
            startActivity(Intent(this, MyCartActivity::class.java))
        }

    }
}