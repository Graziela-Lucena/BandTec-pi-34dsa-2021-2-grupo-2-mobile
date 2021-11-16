package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import com.example.justgeek_base_app.R

class TutorialFirstFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_four)

        val backButton = findViewById<AppCompatImageView>(R.id.ic_back_to_step_four)
        val finishButton = findViewById<AppCompatImageView>(R.id.ic_go_to_homepage)

        finishButton.setOnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            startActivity(intent)
        }
        backButton.setOnClickListener { finish() }
    }
}