package com.example.justgeek_base_app

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CalendarView
import androidx.appcompat.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.concrete.canarinho.watcher.MascaraNumericaTextWatcher

class SingUpBirthDateFragment: Fragment(R.layout.fragment_sign_up_third_step_birthdate) {

    private val birthDayArgs: SingUpBirthDateFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val birthDate = view.findViewById<AppCompatEditText>(R.id.birthdate)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_birthday)
        val valid = view.findViewById<AppCompatImageView>(R.id.check_date)
        val invalid = view.findViewById<AppCompatImageView>(R.id.check_date_invalid)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 3)
        val calendar = view.findViewById<CalendarView>(R.id.calendar)
        calendar.setDate(System.currentTimeMillis(), false, true)

        birthDate.addTextChangedListener(MascaraNumericaTextWatcher("##-##-####"))

        birthDate.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
               if(birthDate.text.isNullOrEmpty()) {
                   invalid.isVisible = true
                   valid.visibility = View.INVISIBLE
               } else {
                   invalid.isVisible = false
                   valid.visibility = View.VISIBLE
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
                SingUpBirthDateFragmentDirections.actionSingUpBirthDateFragmentToSingUpContactsFragment(
                    birthDayArgs.nameUser,
                    birthDayArgs.lastNameUser,
                    birthDayArgs.cpfUser,
                    birthDate.text.toString()
                )
            )
        }
    }
}