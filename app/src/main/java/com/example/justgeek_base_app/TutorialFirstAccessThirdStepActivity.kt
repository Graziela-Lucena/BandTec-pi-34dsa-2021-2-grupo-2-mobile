package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstAccessThirdStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_access_third_step)

        val closeSecondStep : AppCompatImageView = findViewById(R.id.icon_refuse_third_step_tutorial)

        val backToSecondStepButton : AppCompatImageView = findViewById(R.id.ic_back_step_two)

        val goToStepFour : AppCompatImageView = findViewById(R.id.ic_go_to_step_four)

        backToSecondStepButton.setOnClickListener { v -> backToStepTwo(v) }

        goToStepFour.setOnClickListener { v -> nextStepFour(v) }
    }

    private fun backToStepTwo(v:View) {
        finish()
    }

    private fun nextStepFour(v: View) {
        startActivity(Intent(this,
            TutorialFirstAccestEndedPageActivity::class.java))
    }
}