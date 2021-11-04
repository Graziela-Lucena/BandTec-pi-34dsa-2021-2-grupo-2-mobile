package com.example.justgeek_base_app

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.justgeek_base_app.data.DataUser
import com.example.justgeek_base_app.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.regex.Pattern

class SingUpPasswordFragment: Fragment(R.layout.fragment_sing_up_fifth_step_password) {

    val passwordArgs: SingUpPasswordFragmentArgs by navArgs()
    val userViewModel: UserViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("grazi", "create-psw")
        val password = view.findViewById<EditText>(R.id.password)
        val confirmPassword = view.findViewById<EditText>(R.id.confirm_password)
        val errorMessage = view.findViewById<AppCompatTextView>(R.id.error_message_password)
        val errorMessageConfirm = view.findViewById<AppCompatTextView>(R.id.error_message_confirm_password)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_password)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 5)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val validPassword = view.findViewById<AppCompatImageView>(R.id.check_password)
        val validConfirm = view.findViewById<AppCompatImageView>(R.id.check_confirm_password)
        val invalidPassword = view.findViewById<AppCompatImageView>(R.id.check_invalid_password)
        val invalidConfirm = view.findViewById<AppCompatImageView>(R.id.check_invalid_confirm_password)

        var passwordResult: String? = null

        password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val pattern =  Pattern.compile("[A-Za-z0-9]*([a-zA-Z]+[0-9]+|[0-9]+[a-zA-Z]+)")
                val matcher = pattern.matcher(password.text.toString())
                when {
                    password.text.isNullOrEmpty() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    password.text.trim().toString().length < 8 -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.")
                    }
                    !matcher.matches() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa conter pelo menos uma letra e um número.")
                    }
                    password.text.trim().toString().length < 8 && !matcher.matches() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.\nSua senha precisa conter pelo menos uma letra e um número.")
                    }
                    else -> {
                        validPassword.visibility = View.VISIBLE
                        invalidPassword.visibility = View.GONE
                        errorMessage.isVisible = false
                        buttonNext.isClickable = true
                        passwordResult = password.text.toString()
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
                        invalidConfirm.visibility = View.VISIBLE
                        validConfirm.visibility = View.INVISIBLE
                        errorMessageConfirm.isVisible = true
                        buttonNext.isClickable = false
                        errorMessageConfirm.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    confirmPassword.text.toString() != passwordResult -> {
                        invalidConfirm.visibility = View.VISIBLE
                        validConfirm.visibility = View.INVISIBLE
                        errorMessageConfirm.isVisible = true
                        buttonNext.isClickable = false
                        errorMessageConfirm.text = resources.getString(R.string.error_message, "Suas senhas não são iguais.")
                    }
                    else -> {
                        invalidConfirm.visibility = View.INVISIBLE
                        validConfirm.visibility = View.VISIBLE
                        errorMessageConfirm.isVisible = false
                        buttonNext.isClickable = true
                    }
                }

            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        buttonNext.setOnClickListener {
            userViewModel.singUpUser(
                DataUser(
                passwordArgs.nameUser,
                passwordArgs.lastNameUser,
                passwordArgs.cpfUser,
                passwordArgs.birthdateUser,
                passwordArgs.emailUser,
                passwordArgs.phoneUser,
                password.text.toString()
            )
            ).observe(viewLifecycleOwner) {
                data {
                    Log.i("grazi", "data")
                    findNavController().navigate(SingUpPasswordFragmentDirections.actionSingUpPasswordFragmentToSingUpLoginFragment())
                }
                error { e ->
                    Log.i("grazi", e.toString())
                    Toast.makeText(requireContext(), "Erro ao fazer o cadastro", Toast.LENGTH_SHORT)
                }

            }
        }

    }
}