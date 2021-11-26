package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val btn_add_to_cart = findViewById<AppCompatButton>(R.id.button_add_to_cart)

        btn_add_to_cart.setOnClickListener {
            val view = View.inflate(this@ProductActivity,
                R.layout.dialog_add_product_to_cart, null)

            val builder = AlertDialog.Builder(this@ProductActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.findViewById<AppCompatImageView>(R.id.ic_close_dialog_add_to_cart)
                .setOnClickListener {
                    dialog.dismiss()
                }

            view.findViewById<AppCompatButton>(R.id.button_continue_to_buy)
                .setOnClickListener {
                    dialog.dismiss()
                }

            view.findViewById<AppCompatButton>(R.id.button_go_to_cart)
                .setOnClickListener {
                    startActivity(Intent(this, MyCartActivity::class.java))
                }
        }

        val fragmentTransactionWithoutAddress = supportFragmentManager.beginTransaction()
        val withoutAddressItem = WithoutAddressFragment()

        fragmentTransactionWithoutAddress.add(R.id.fragment_address_request, withoutAddressItem)
        fragmentTransactionWithoutAddress.commit()
    }
}