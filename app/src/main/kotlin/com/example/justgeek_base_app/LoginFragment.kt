package com.example.justgeek_base_app


import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment: Fragment(R.layout.activity_main_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val singUpButton = view.findViewById<AppCompatButton>(R.id.button_sign_up)
        val singInButton = view.findViewById<AppCompatButton>(R.id.button_sign_in)

        singUpButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSingUpNameFragment())
        }

        singInButton.setOnClickListener {

        }
    }
}