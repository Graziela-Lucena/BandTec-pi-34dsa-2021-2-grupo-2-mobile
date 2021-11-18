package com.example.justgeek_base_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.MyCartOrderConfirmationAdapter
import com.example.justgeek_base_app.data.OrderItemConfirmation

class MyCartOrderConfirmationFragment : Fragment(R.layout.fragment_my_cart_order_confirmation) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOrdersConfirmation : List<OrderItemConfirmation> = mutableListOf(
            OrderItemConfirmation(
                R.drawable.popular1,
                getString(R.string.title_quantity_product_chosen)
            ),
            OrderItemConfirmation(
                R.drawable.popular1,
                getString(R.string.title_quantity_product_chosen)
            ),
            OrderItemConfirmation(
                R.drawable.popular1,
                getString(R.string.title_quantity_product_chosen)
            ),
        )
        val adapter = MyCartOrderConfirmationAdapter(listOrdersConfirmation)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
            false)
        val items = view.findViewById<RecyclerView>(R.id.recycler_order_confirmation)

        items.adapter = adapter
        items.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(items)
    }
}