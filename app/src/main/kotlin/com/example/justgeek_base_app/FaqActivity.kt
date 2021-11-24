package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ms.square.android.expandabletextview.ExpandableTextView

class FaqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faq)

        val expTv: ExpandableTextView = findViewById(R.id.expand_text_view)
        val expTvTwo: ExpandableTextView = findViewById(R.id.expand_text_payment_promotion)
        val expTvThree: ExpandableTextView = findViewById(R.id.expand_text_return_refund)
        val expTvFour: ExpandableTextView = findViewById(R.id.expand_text_delivery)
        val expTvFive: ExpandableTextView = findViewById(R.id.expand_text_account)
//
        expTv.setText(getString(R.string.text_faq_answer_option_product_custom))
//
        expTvTwo.setText(getString(R.string.text_faq_answer_option_payment_promotion))

        expTvThree.setText(getString(R.string.text_faq_answer_option_return_refund))

        expTvFour.setText(getString(R.string.text_faq_answer_option_delivery))

        expTvFive.setText(getString(R.string.text_faq_answer_option_account))
    }
}