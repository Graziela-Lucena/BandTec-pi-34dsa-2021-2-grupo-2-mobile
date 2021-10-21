package com.example.justgeek_base_app


import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginActivity: AppCompatActivity(R.layout.activity_main_login) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        val singUpButton = findViewById<AppCompatButton>(R.id.button_sign_up)
        val singInButton = findViewById<AppCompatButton>(R.id.button_sign_in)

        singUpButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Log.i("grazi", "REQUEST")
        }

        singInButton.setOnClickListener {

        }
    }
}