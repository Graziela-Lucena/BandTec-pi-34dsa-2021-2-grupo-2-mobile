package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import com.example.justgeek_base_app.data.ProductItem
import com.example.justgeek_base_app.data.UserData
import com.example.justgeek_base_app.repository.ProductRepository
import com.example.justgeek_base_app.viewmodel.CartViewModel
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import com.google.android.material.chip.ChipGroup
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ArtistFormActivity : AppCompatActivity(R.layout.activity_artist_form) {
    val productVM: ProductRepository by inject()
    val viewModel: CartViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val img = intent.getStringExtra("imageProduct")
        productVM.rp(ProductItem(50,"", "Camiseta artista", "50.00", "", listOf(img), "camiseta customizada"  ) )
        val btnRequestArtist = findViewById<AppCompatButton>(R.id.button_finish_request_artist)
        btnRequestArtist.setOnClickListener {
            viewModel.addToCart(UserData.userId, 50, 1, "G")
            startActivity(Intent(this, MyCartActivity::class.java))
        }
    }
}