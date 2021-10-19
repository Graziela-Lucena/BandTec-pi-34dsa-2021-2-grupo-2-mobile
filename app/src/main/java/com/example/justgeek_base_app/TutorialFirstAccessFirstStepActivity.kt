package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstAccessFirstStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_access_first_step)

        val closeButton : AppCompatImageView = findViewById(R.id.icon_refuse_first_step_tutorial)

        val goToSecondStepButton : AppCompatImageView = findViewById(R.id.go_to_second_step)

        goToSecondStepButton.setOnClickListener { v -> nextStep(v) }

        closeButton.setOnClickListener { v -> closeScreen(v)}


    }

    private fun closeScreen(v:View) {
        finish()
    }
    private fun nextStep(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessSecondStepActivity::class.java))
    }
}