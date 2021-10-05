package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class SingUpContactsFragment: Fragment(R.layout.fragment_sing_up_fourth_step_contacts) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonBack = view.findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = view.findViewById<AppCompatButton>(R.id.continue_button)
        val email = view.findViewById<AppCompatEditText>(R.id.email)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val pageIndicator = view.findViewById<AppCompatTextView>(R.id.page_indicator_contacts)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 4)

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
        }
    }

}