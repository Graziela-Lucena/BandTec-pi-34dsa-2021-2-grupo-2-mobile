package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import java.util.*

class SingUpBirthDateFragment: Fragment(R.layout.fragment_sign_up_third_step_birthdate) {

    private val birthDayArgs: SingUpBirthDateFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val birthDate = view.findViewById<AppCompatEditText>(R.id.birthdate)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_birthday)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 3)
        val calendar = view.findViewById<CalendarView>(R.id.calendar)
        calendar.setDate(System.currentTimeMillis(), false, true)

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
                    birthDate.text.toString(),
                    birthDayArgs.nameUser,
                    birthDayArgs.lastNameUser,
                    birthDayArgs.cpfUser
                )
            )
        }
    }
}