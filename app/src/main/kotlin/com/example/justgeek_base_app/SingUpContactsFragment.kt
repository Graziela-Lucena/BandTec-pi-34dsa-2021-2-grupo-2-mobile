package com.example.justgeek_base_app

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class SingUpContactsFragment: Fragment(R.layout.fragment_sing_up_fourth_step_contacts) {

    val contactArgs: SingUpContactsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val email = view.findViewById<AppCompatEditText>(R.id.email)
        val cellphone = view.findViewById<AppCompatEditText>(R.id.cellphone)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_contacts)
        val checkValidEmail = view.findViewById<AppCompatImageView>(R.id.check_email)
        val checkInvalidEmail = view.findViewById<AppCompatImageView>(R.id.check_email_invalid)
        val checkValidCellphone = view.findViewById<AppCompatImageView>(R.id.cellphone_check)
        val checkInvalidCellphone = view.findViewById<AppCompatImageView>(R.id.cellphone_check_invalid)
        val errorMessageEmail = view.findViewById<AppCompatTextView>(R.id.error_message_email)
        val errorMessagePhone = view.findViewById<AppCompatTextView>(R.id.error_message_phone)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 4)

        cellphone.addTextChangedListener(MascaraNumericaTextWatcher("(##) #####-####"))

        email.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    email.text.isNullOrEmpty() -> {
                        checkValidEmail.visibility = View.INVISIBLE
                        checkInvalidEmail.isVisible = true
                        errorMessageEmail.text = resources.getString(R.string.error_message, "Você precisa inserir um email")
                    }
                    android.util.Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches() -> {
                        checkValidEmail.visibility = View.VISIBLE
                        checkInvalidEmail.isVisible = false
                        errorMessageEmail.isVisible = false
                    }
                    else -> {
                        checkValidEmail.visibility = View.INVISIBLE
                        checkInvalidEmail.isVisible = true
                        errorMessageEmail.isVisible = true
                        errorMessageEmail.text = resources.getString(R.string.error_message, "Você precisa inserir um email válido")
                    }
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        cellphone.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    cellphone.text.isNullOrEmpty() -> {
                        checkValidCellphone.visibility = View.INVISIBLE
                        checkInvalidCellphone.isVisible = true
                        errorMessagePhone.isVisible = true
                        errorMessagePhone.text = resources.getString(R.string.error_message, "Você precisa inserir um telefone celular")
                    }
                    else -> {
                        checkValidCellphone.visibility = View.VISIBLE
                        checkInvalidCellphone.isVisible = false
                        errorMessagePhone.isVisible = false
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        fun goBack() {
            findNavController().popBackStack()
        }

        toolbar.setNavigationOnClickListener {
            goBack()
        }
        buttonBack.setOnClickListener {
            goBack()
        }
        buttonNext.setOnClickListener {
            findNavController().navigate(
                SingUpContactsFragmentDirections.actionSingUpContactsFragmentToSingUpPasswordFragment(
                    email.text.toString(),
                    cellphone.text.toString(),
                    contactArgs.nameUser,
                    contactArgs.lastNameUser,
                    contactArgs.cpfUser,
                    contactArgs.birthdateUser
                )
            )

        }
    }

}