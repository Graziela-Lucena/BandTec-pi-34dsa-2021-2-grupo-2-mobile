package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.OrderAdapter
import com.example.justgeek_base_app.data.OrderData

class ProductFragment: Fragment(R.layout.fragment_profile_recent_orders) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val orderList : List<OrderData> = mutableListOf(
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment),

            ),
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment),
            ),
        )
        val adapterOrder = OrderAdapter(orderList)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val orders = view.findViewById<RecyclerView>(R.id.recycler_orders)
        orders.adapter = adapterOrder
        orders.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(orders)
    }
}