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
import br.com.concrete.canarinho.validator.Validador
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class SingUpCpfFragment: Fragment(R.layout.fragment_sing_up_second_step_cpf) {

    private val cpfArgs: SingUpCpfFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val cpf = view.findViewById<AppCompatEditText>(R.id.cpf)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator)
        val errorMessage = view.findViewById<AppCompatTextView>(R.id.error_message_cpf)
        val checkValid = view.findViewById<AppCompatImageView>(R.id.check_valid)
        val checkInValid = view.findViewById<AppCompatImageView>(R.id.check_invalid)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 2)

        cpf.addTextChangedListener(MascaraNumericaTextWatcher("###.###.###-##"))

        cpf.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                errorMessage.isVisible = !s.isNullOrEmpty()
                if(Validador.CPF.ehValido(cpf.text.toString())) {
                    cpf.setTextColor(resources.getColor(R.color.black, null))
                    errorMessage.isVisible = false
                    buttonNext.isClickable = true
                    checkValid.isVisible = true
                    checkInValid.isVisible = false
                } else {
                    cpf.setTextColor(resources.getColor(R.color.light_pink, null))
                    buttonNext.isClickable = false
                    errorMessage.isVisible = true
                    checkValid.visibility = View.INVISIBLE
                    errorMessage.text = resources.getString(R.string.error_message, "CPF Inválido")
                    checkInValid.isVisible = !s.isNullOrEmpty()
                }
            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

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
                SingUpCpfFragmentDirections.actionSingUpCpfFragmentToSingUpBirthDateFragment(
                    cpfArgs.nameUser, cpfArgs.lastNameUser, cpf.text.toString()
                )
            )
        }
    }
}