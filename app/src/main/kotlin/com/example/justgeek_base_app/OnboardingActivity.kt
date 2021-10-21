package com.example.justgeek_base_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class OnboardingActivity: AppCompatActivity(R.layout.activity_onboarding) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("grazi", "create-teste")
    }
}