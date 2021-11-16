package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView

class MainLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        val signUpButton : AppCompatButton = findViewById(R.id.button_sign_up)

        val signInButton : AppCompatButton = findViewById(R.id.button_sign_in)

        signUpButton.setOnClickListener { v -> redirectToSignUp(v) }

        signInButton.setOnClickListener { v -> login(v) }
    }

    private fun redirectToSignUp(v:View) {
        startActivity(Intent(this, SingUpNameFragment::class.java))
    }

    private fun login(v:View) {
        val inputEmail : AppCompatEditText = findViewById(R.id.input_email)
        val inputPassword : AppCompatEditText = findViewById(R.id.input_password)
        val icErrorPassword : AppCompatImageView = findViewById(R.id.icon_refuse_password_error)
        val msgErrorPassword : AppCompatTextView = findViewById(R.id.text_wrong_password)
        val icErrorEmail : AppCompatImageView = findViewById(R.id.icon_refuse_email_error)
        val msgErrorEmail : AppCompatTextView = findViewById(R.id.text_wrong_email)

        when  {
            inputEmail.text.isNullOrEmpty() -> msgErrorEmail.visibility = View.VISIBLE
            inputEmail.text.isNullOrEmpty() -> icErrorPassword.visibility = View.VISIBLE
            inputPassword.text.isNullOrEmpty() -> msgErrorPassword.visibility = View.VISIBLE
            inputPassword.text.isNullOrEmpty() -> icErrorEmail.visibility - View.VISIBLE
            else -> "Deu certo"
        }
    }
}