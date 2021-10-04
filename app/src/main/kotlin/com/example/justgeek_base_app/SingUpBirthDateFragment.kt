package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import java.util.*

class SingUpBirthDateFragment: Fragment() {

    private val birthDayArgs: SingUpBirthDateFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val birthDate = view.findViewById<AppCompatEditText>(R.id.birthdate)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_birthday)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 3)
        val calendar = view.findViewById<CalendarView>(R.id.calendar)
        calendar.setDate(System.currentTimeMillis(), false, true)

        buttonBack.setOnClickListener {

        }
        buttonNext.setOnClickListener {
            findNavController().navigate(
                SingUpNameFragmentDirections.actionSingUpNameFragmentToSingUpCpfFragment(
                    birthDate.text.toString(), birthDayArgs.cpfUser
                )
            )
        }
    }
}