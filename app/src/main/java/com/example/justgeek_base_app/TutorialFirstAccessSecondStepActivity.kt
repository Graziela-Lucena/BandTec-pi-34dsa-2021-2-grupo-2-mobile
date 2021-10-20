package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstAccessSecondStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_access_second_step)

        val closeSecondStep : AppCompatImageView = findViewById(R.id.icon_refuse_second_step_tutorial)

        val backStepOneButton : AppCompatImageView = findViewById(R.id.ic_back_step_one)

        val goToStepThreeButton : AppCompatImageView = findViewById(R.id.go_to_step_three)

        goToStepThreeButton.setOnClickListener { v -> nextStepThree(v) }

        backStepOneButton.setOnClickListener { v -> backStepOne(v) }
    }

    private fun backStepOne(v:View) {
        finish()
    }

    private fun nextStepThree(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessThirdStepActivity::class.java))
    }
}