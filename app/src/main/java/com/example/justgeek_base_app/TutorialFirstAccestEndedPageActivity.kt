package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstAccestEndedPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_accest_ended_page)

        val closeFinalStep : AppCompatImageView = findViewById(R.id.icon_refuse_last_step_tutorial)

        val backToStepFourButton : AppCompatImageView = findViewById(R.id.ic_back_to_step_four)

        backToStepFourButton.setOnClickListener { v -> backToThirdStep(v) }
    }

    private fun backToThirdStep(v:View) {
        finish()
    }
}