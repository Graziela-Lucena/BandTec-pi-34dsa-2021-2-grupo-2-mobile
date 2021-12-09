package com.example.justgeek_base_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductImageAdapter
import com.example.justgeek_base_app.viewmodel.CommentViewModel
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductActivity : AppCompatActivity(R.layout.activity_product) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productViewModel: ProductViewModel by viewModel()
        val ratingViewModel: CommentViewModel by viewModel()
        val productName = findViewById<TextView>(R.id.title_name_product)
        val productPrice = findViewById<TextView>(R.id.product_price)
        val oldProductPrice = findViewById<TextView>(R.id.product_old_price)
        val installment = findViewById<TextView>(R.id.text_installment)
        val averageRate = findViewById<TextView>(R.id.text_average)
        val pageIndicator = findViewById<TextView>(R.id.pointer_image)

//        val idProduct = intent.getIntExtra("idProduto", 2)
          val idProduct = 1

        val recyclerViewImages = findViewById<RecyclerView>(R.id.product_image)

        recyclerViewImages.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        productViewModel.getProductById(idProduct).observe(this) {
            data{
                recyclerViewImages.adapter = ProductImageAdapter(it.productImage)
                productName.text = it.name
                productPrice.text = it.price
                oldProductPrice.text = (it.price.toDouble() * 2).toString()
                installment.text = resources.getString (R.string.installments, it.price.toDouble() / 2)
                pageIndicator.text = resources.getString(R.string.product_step, 1, it.productImage?.size)
                Log.i("grazi", it.toString())
            }
            error { t->
                Log.i("grazi", t.toString())
            }
        }

        ratingViewModel.getProductComments(idProduct).observe(this) {
            data {
                val list = it
                val listSize = it.size
               it.map {
                   var cont: Int = listSize
                   var average = 0f
                   var rate = 0f
                   while (cont >= 0) {
                       rate += list.getOrNull(cont)?.rate ?: 0f
                       average = rate / listSize
                       cont--
                   }
                   averageRate.text = average.toString()
                }
            }
        }

        PagerSnapHelper().attachToRecyclerView(recyclerViewImages)

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
        val reviewFragment = ProductReviewFragment(idProduct)

        fragmentTransactionWithoutAddress.add(R.id.fragment_address_request, withoutAddressItem)
        fragmentTransactionWithoutAddress.commit()
        fragmentTransactionReview.add(R.id.fragment_comments_reviews, reviewFragment)
        fragmentTransactionReview.commit()
    }
}