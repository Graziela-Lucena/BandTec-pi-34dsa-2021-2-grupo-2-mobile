package com.example.justgeek_base_app

import android.os.Bundle
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

        fun checkNameValidation(): Boolean {
            errorMessage?.isVisible = false
            validName?.visibility = View.INVISIBLE
            invalidName?.visibility = View.GONE
            val filteredText = name.text.trim().length
            when {
                name.text.isNullOrEmpty() -> {
                    invalidName?.visibility = View.VISIBLE
                    errorMessage?.isVisible = true
                    errorMessage?.text = resources.getString(
                        R.string.error_message,
                        "Você precisa inserir um nome válido."
                    )
                    return false
                }
                filteredText <= 2 -> {
                    invalidName?.visibility = View.VISIBLE
                    errorMessage?.isVisible = true
                    errorMessage?.text = resources.getString(
                        R.string.error_message,
                        "Seu nome precisa ter mais de duas letras!"
                    )
                    return false
                }
                else -> {
                    validName?.visibility = View.VISIBLE
                    invalidName?.visibility = View.GONE
                    errorMessage?.isVisible = false
                    return true
                }
            }
        }

        fun checkLastNameValidation(): Boolean {
            errorMessageLastName?.isVisible = false
            validLastName?.visibility = View.INVISIBLE
            invalidLastName?.visibility = View.GONE
            val filteredText = lastName.text.trim().length
            when {
                lastName.text.isNullOrEmpty() -> {
                    invalidLastName?.visibility = View.VISIBLE
                    errorMessageLastName?.isVisible = true
                    errorMessageLastName?.text = resources.getString(
                        R.string.error_message,
                        "Você precisa inserir um sobrenome válido."
                    )
                    return false
                }
                filteredText <= 2 -> {
                    invalidLastName?.visibility = View.VISIBLE
                    errorMessageLastName?.isVisible = true
                    errorMessageLastName?.text = resources.getString(
                        R.string.error_message,
                        "Seu sobrenome precisa ter mais de duas letras!"
                    )
                    return false
                }
                else -> {
                    validLastName?.visibility = View.VISIBLE
                    invalidLastName?.visibility = View.GONE
                    errorMessageLastName?.isVisible = false
                    return true
                }
            }
        }


        buttonNext?.setOnClickListener {
            val validName: Boolean = checkNameValidation()
            val validLastName: Boolean = checkLastNameValidation()
            when {
                validName && validLastName -> {
                    findNavController().navigate(
                        SingUpNameFragmentDirections.actionSingUpNameFragmentToSingUpCpfFragment(
                            name?.text.toString(), lastName?.text.toString()
                        )
                    )
                }
                !validName -> {
                    name?.text?.clear()
                    name?.requestFocus()
                }
                !validLastName -> {
                    lastName?.text?.clear()
                    lastName.requestFocus()
                }
            }
        }
    }
}