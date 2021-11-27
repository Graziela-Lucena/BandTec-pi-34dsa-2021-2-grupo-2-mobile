package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.WithoutAddressAdapter
import com.example.justgeek_base_app.data.WithoutAddressData

class WithoutAddressFragment : Fragment(R.layout.fragment_product_shipping_fee) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item : List<WithoutAddressData> = mutableListOf(
            WithoutAddressData(
                getString(R.string.subtitle_shipping),
                getString(R.string.link_shipping_add_address)
            )
        )
        val adapter = WithoutAddressAdapter(item)
        val layout = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)
        val withoutAddress = view.findViewById<RecyclerView>(R.id.without_address_recycler)

        withoutAddress.adapter = adapter
        withoutAddress.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(withoutAddress)
    }
}