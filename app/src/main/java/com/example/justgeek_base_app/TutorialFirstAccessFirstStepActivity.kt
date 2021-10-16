package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TutorialFirstAccessFirstStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_access_first_step)
    }

    fun nextStep(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessSecondStepActivity::class.java))
    }
}