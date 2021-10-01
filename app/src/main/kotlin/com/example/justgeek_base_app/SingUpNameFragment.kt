package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SingUpNameFragment : Fragment(R.layout.fragment_sing_up_first_step_name) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<EditText>(R.id.name)
        val lastName = view.findViewById<EditText>(R.id.last_name)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 1)

        buttonNext.setOnClickListener {
            when{
                name.text.isNullOrEmpty() -> {
                    "aparecer mensagem de erro"
                }
                name.text.trim().split(" ").filter { it.length >= 3 }.size < 2 -> {
                    "seu nome precisa ter mais de duas letras"
                }
            }
            findNavController().navigate(
                SingUpNameFragmentDirections.actionSingUpNameFragmentToSingUpCpfFragment(
                    name.text.toString(), lastName.text.toString()
                )
            )
        }

    }
}