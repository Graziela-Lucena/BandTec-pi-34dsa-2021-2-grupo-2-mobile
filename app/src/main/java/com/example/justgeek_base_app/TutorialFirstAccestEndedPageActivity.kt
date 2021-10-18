package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class TutorialFirstAccestEndedPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_accest_ended_page)
    }

    fun backToThirdStep(v:View) {
        startActivity(Intent(this,
            TutorialFirstAccessThirdStepActivity::class.java))
    }
}