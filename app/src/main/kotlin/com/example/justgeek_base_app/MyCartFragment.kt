package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductCartAdapter
import com.example.justgeek_base_app.data.ProductCartData

class MyCartFragment:Fragment(R.layout.fragment_my_cart) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartList : List<ProductCartData> = mutableListOf(
            ProductCartData(
                R.drawable.popular1,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.title_result_quantity)
            ),
            ProductCartData(
                R.drawable.popular1,
                getString(R.string.title_product_name),
                getString(R.string.subtitle_new_price),
                getString(R.string.title_result_quantity)
            ),
        )

        val adapterCart = ProductCartAdapter(cartList)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val items = view.findViewById<RecyclerView>(R.id.recycler_my_cart)
        items.adapter = adapterCart
        items.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(items)
    }
}