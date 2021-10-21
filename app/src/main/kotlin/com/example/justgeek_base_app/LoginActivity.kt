package com.example.justgeek_base_app


import android.content.Intent
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView

class LoginActivity: AppCompatActivity(R.layout.activity_main_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val singUpButton = findViewById<AppCompatButton>(R.id.button_sign_up)
        val singInButton = findViewById<AppCompatButton>(R.id.button_sign_in)
        val version = findViewById<AppCompatTextView>(R.id.version)
        version.text = resources.getString(R.string.title_version_app_login, "1.0.0")

        singUpButton.setOnClickListener {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }

        singInButton.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
    }
}