package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TutorialFirstAccessSecondStepActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_access_second_step)
    }

    fun backStepOne(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessFirstStepActivity::class.java))
    }

    fun nextStepThree(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessThirdStepActivity::class.java))
    }
}