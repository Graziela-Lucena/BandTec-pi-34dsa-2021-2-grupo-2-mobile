package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

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
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 2)

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
                    cpf.text.toString(), cpfArgs.nameUser, cpfArgs.lastNameUser
                )
            )
        }
    }
}