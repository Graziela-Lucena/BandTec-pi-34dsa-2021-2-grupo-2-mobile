package com.example.justgeek_base_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductPromotionCartAdapter
import com.example.justgeek_base_app.data.ProductItem

class MyCartPromotionFragment:Fragment(R.layout.fragment_my_cart_promotion) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cartPromotionsList : List<ProductItem> = mutableListOf(
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
            ProductItem(
                getString(R.string.tag_promotion),
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.subtitle_old_price),
                R.drawable.popular1
            ),
        )

        val adapter = ProductPromotionCartAdapter(cartPromotionsList)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val itemsCartPromotion = view.findViewById<RecyclerView>(R.id.recycler_promo_cart)

        itemsCartPromotion.adapter = adapter
        itemsCartPromotion.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(itemsCartPromotion)
    }
}