package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SingUpLoginFragment: Fragment(R.layout.fragment_sing_up_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loginButton = view.findViewById<AppCompatButton>(R.id.login_button)

        loginButton.setOnClickListener {
           requireActivity().finish()
        }

    }
}