package com.example.justgeek_base_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class MyCartOrderConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart_order_confirmation)

        val btn_proceed = findViewById<AppCompatButton>(R.id.button_proceed_order)
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val orderConfirmation = MyCartOrderConfirmationFragment()
        fragmentTransaction.add(R.id.fragment_bag_items_cart_confirmation, orderConfirmation)
        fragmentTransaction.commit()

        btn_proceed.setOnClickListener {
            val view = View.inflate(this@MyCartOrderConfirmationActivity,
            R.layout.dialog_order_confirmation, null)

            val builder = AlertDialog.Builder(this@MyCartOrderConfirmationActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.findViewById<AppCompatImageView>(R.id.ic_close_dialog).setOnClickListener {
                dialog.dismiss()
                }

            view.findViewById<AppCompatButton>(R.id.btn_refuse_dialog).setOnClickListener {
                dialog.dismiss()
                }
            }
        }
    }