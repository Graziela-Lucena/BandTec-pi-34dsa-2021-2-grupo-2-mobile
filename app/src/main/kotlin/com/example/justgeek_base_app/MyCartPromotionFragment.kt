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
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MyCartPromotionFragment:Fragment(R.layout.fragment_my_cart_promotion) {
    val productViewModel: ProductViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val itemsCartPromotion = view.findViewById<RecyclerView>(R.id.recycler_promo_cart)

        itemsCartPromotion.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(itemsCartPromotion)

        productViewModel.getPromotionalProduct().observe(viewLifecycleOwner) {
            data {
                val adapter = ProductPromotionCartAdapter(it)
                itemsCartPromotion.adapter = adapter
            }
        }
    }
}