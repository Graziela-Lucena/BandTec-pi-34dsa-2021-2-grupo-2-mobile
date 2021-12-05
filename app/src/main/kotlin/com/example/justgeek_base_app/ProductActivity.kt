package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat

class ProductActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val btn_add_to_cart = findViewById<AppCompatButton>(R.id.button_add_to_cart)

        val btn_add_to_favorites = findViewById<AppCompatImageView>(R.id.button_add_to_favorites)

        val addedToCart = false

        val quantity = findViewById<AppCompatTextView>(R.id.text_quantity_variable)

        var mutableQuantity = 0

        val btn_plus = findViewById<AppCompatButton>(R.id.button_text_plus)
        val btn_less = findViewById<AppCompatButton>(R.id.button_text_less)

        btn_plus.setOnClickListener {
            mutableQuantity ++
            quantity.text = "$mutableQuantity"
        }

        btn_less.setOnClickListener {
            mutableQuantity --
            quantity.text = "$mutableQuantity"
        }


        btn_add_to_favorites.setOnClickListener {
            if (addedToCart == false) {
                btn_add_to_favorites.setImageDrawable(getDrawable(R.drawable.ic_id_favorite_filled))
            } else {
                btn_add_to_favorites.setImageDrawable(getDrawable(R.drawable.ic_navigation_bar_favorite_icon))
            }

            val view = View.inflate(this@ProductActivity,
            R.layout.dialog_product_added_to_favorites, null)

            val builder = AlertDialog.Builder(this@ProductActivity)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            view.findViewById<AppCompatImageView>(R.id.ic_close_dialog_added_to_favorites)
                .setOnClickListener {
                    dialog.dismiss()
                }

            view.findViewById<AppCompatButton>(R.id.button_see_my_favorites)
                .setOnClickListener {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                }
        }

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
        val fragmentTransactionReview = supportFragmentManager.beginTransaction()
        val reviewFragment = ProductReviewFragment()

        fragmentTransactionWithoutAddress.add(R.id.fragment_address_request, withoutAddressItem)
        fragmentTransactionWithoutAddress.commit()
        fragmentTransactionReview.add(R.id.fragment_comments_reviews, reviewFragment)
        fragmentTransactionReview.commit()
    }
}