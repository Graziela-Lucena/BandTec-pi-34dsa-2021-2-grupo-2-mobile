package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProfileOrderAdapter
import com.example.justgeek_base_app.data.OrderData

class ProfileOrderFragment:Fragment(R.layout.fragment_profile_orders) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listOrders : List<OrderData> = mutableListOf(
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            ),
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            ),
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            ),
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            ),
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            ),
        )
        val adapter = ProfileOrderAdapter(listOrders)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val orders = view.findViewById<RecyclerView>(R.id.orders_recycler)
        orders.adapter = adapter
        orders.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(orders)
    }
}