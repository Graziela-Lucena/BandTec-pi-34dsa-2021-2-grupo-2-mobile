package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class ArtistFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_form)

        val btnRequestArtist = findViewById<AppCompatButton>(R.id.button_finish_request_artist)
        btnRequestArtist.setOnClickListener {
            val view = View.inflate(this@ArtistFormActivity, R.layout.dialog_order_confirmation, null)

            val builder = AlertDialog.Builder(this@ArtistFormActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.findViewById<AppCompatImageView>(R.id.ic_close_dialog).setOnClickListener {
                dialog.dismiss()
            }

            view.findViewById<AppCompatButton>(R.id.btn_refuse_dialog).setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}