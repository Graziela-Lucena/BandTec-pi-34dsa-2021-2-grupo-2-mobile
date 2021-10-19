package com.example.justgeek_base_app

import android.os.Bundle
import android.os.PatternMatcher
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import br.com.concrete.canarinho.validator.Validador
import java.util.regex.Matcher
import java.util.regex.Pattern

class SingUpPasswordFragment: Fragment(R.layout.fragment_sing_up_fifth_step_password) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val password = view.findViewById<EditText>(R.id.password)
        val confirmPassword = view.findViewById<EditText>(R.id.confirm_password)
        val errorMessage = view.findViewById<AppCompatTextView>(R.id.error_message_password)
        val errorMessageConfirm = view.findViewById<AppCompatTextView>(R.id.error_message_confirm_password)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_password)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 5)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)

        fun passwordValidation(): Boolean {
            val pattern =  Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=\\\\S+\$).{4,}\$")
            val matcher = pattern.matcher(password.text.toString())
            return matcher.matches()
        }

        val validate = passwordValidation()

        password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    password.text.isNullOrEmpty() -> {
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    password.text.trim().toString().length < 8 -> {
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.")
                    }
                    !validate -> {
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa conter pelo menos uma letra e um número.")
                    }
                    password.text.trim().toString().length < 8 && !validate -> {
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.\nSua senha precisa conter pelo menos uma letra e um número.")
                    }
                }

            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })


        confirmPassword.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    confirmPassword.text.isNullOrEmpty() -> {
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    confirmPassword.text.toString() != password.text.toString() -> {
                        errorMessageConfirm.isVisible = true
                        buttonNext.isClickable = false
                        errorMessageConfirm.text = resources.getString(R.string.error_message, "Suas senhas não são iguais.")
                    }
                }

            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

    }
}