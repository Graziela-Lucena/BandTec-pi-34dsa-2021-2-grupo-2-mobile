package com.example.justgeek_base_app

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SingUpNameFragment : Fragment(R.layout.fragment_sing_up_first_step_name) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val name = view.findViewById<EditText>(R.id.name)
        val lastName = view.findViewById<EditText>(R.id.last_name)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator)
        val validName = view.findViewById<AppCompatImageView>(R.id.check_name)
        val validLastName = view.findViewById<AppCompatImageView>(R.id.check_last_name)
        val invalidName = view.findViewById<AppCompatImageView>(R.id.check_invalid_name)
        val invalidLastName = view.findViewById<AppCompatImageView>(R.id.check_invalid_last_name)
        val errorMessage = view.findViewById<AppCompatTextView>(R.id.error_message_name)
        val errorMessageLastName = view.findViewById<AppCompatTextView>(R.id.error_message_last_name)
        pageIndicator?.text = resources.getString(R.string.page_indicator_text_sign_up, 1)

        var valid: Boolean = false
        var validL: Boolean = false

        name.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val filteredTextName = name.text.trim().length
                when {
                    name.text.isNullOrEmpty() -> {
                        invalidName?.visibility = View.VISIBLE
                        validName?.visibility = View.INVISIBLE
                        errorMessage?.isVisible = true
                        errorMessage?.text = resources.getString(
                            R.string.error_message,
                            "Você precisa inserir um nome válido."
                        )
                        valid = false
                    }
                    filteredTextName <= 2 -> {
                        invalidName?.visibility = View.VISIBLE
                        validName?.visibility = View.INVISIBLE
                        errorMessage?.isVisible = true
                        errorMessage?.text = resources.getString(
                            R.string.error_message,
                            "Seu nome precisa ter mais de duas letras!"
                        )
                        valid = false
                    }
                    else -> {
                        validName?.visibility = View.VISIBLE
                        invalidName?.visibility = View.GONE
                        errorMessage?.isVisible = false
                        valid = true
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        lastName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val filteredTextLastName = lastName.text.trim().length
                when {
                    lastName.text.isNullOrEmpty() -> {
                        invalidLastName?.visibility = View.VISIBLE
                        validLastName?.visibility = View.INVISIBLE
                        errorMessageLastName?.isVisible = true
                        errorMessageLastName?.text = resources.getString(
                            R.string.error_message,
                            "Você precisa inserir um sobrenome válido."
                        )
                        validL = false
                    }
                    filteredTextLastName <= 2 -> {
                        invalidLastName?.visibility = View.VISIBLE
                        validLastName?.visibility = View.INVISIBLE
                        errorMessageLastName?.isVisible = true
                        errorMessageLastName?.text = resources.getString(
                            R.string.error_message,
                            "Seu sobrenome precisa ter mais de duas letras!"
                        )
                        validL = false
                    }
                    else -> {
                        validLastName?.visibility = View.VISIBLE
                        invalidLastName?.visibility = View.GONE
                        errorMessageLastName?.isVisible = false
                        validL = true
                    }
                }
            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        buttonNext?.setOnClickListener {
            if(valid && validL) {
                findNavController().navigate(
                    SingUpNameFragmentDirections.actionSingUpNameFragmentToSingUpCpfFragment(
                        name?.text.toString(), lastName?.text.toString()
                    )
                )
            }
        }
    }
}