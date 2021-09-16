package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SingUpNameFragment : Fragment(R.layout.fragment_sing_up_first_step_name) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<AppCompatTextView>(R.id.name)
        val lastName = view.findViewById<AppCompatTextView>(R.id.last_name)


    }
}