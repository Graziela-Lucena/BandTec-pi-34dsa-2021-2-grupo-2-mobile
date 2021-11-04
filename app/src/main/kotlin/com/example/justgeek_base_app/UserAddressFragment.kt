package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.UserAddressAdapter
import com.example.justgeek_base_app.data.UserAddressData

class UserAddressFragment : Fragment(R.layout.fragment_address) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listAddress : List<UserAddressData> = mutableListOf(
            UserAddressData(
                getString(R.string.addresses_client_name),
                getString(R.string.street_name_addresses_one),
                getString(R.string.number_home_addresses_one),
                getString(R.string.neighborhood_addresses_one),
                getString(R.string.city_addresses_one),
                getString(R.string.cep_addresses_one)
            ),
            UserAddressData(
                getString(R.string.addresses_client_name),
                getString(R.string.street_name_addresses_one),
                getString(R.string.number_home_addresses_one),
                getString(R.string.neighborhood_addresses_one),
                getString(R.string.city_addresses_one),
                getString(R.string.cep_addresses_one)
            ),
        )

        val adapter = UserAddressAdapter(listAddress)

        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val addresses = view.findViewById<RecyclerView>(R.id.address_recycler)

        addresses.adapter = adapter
        addresses.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(addresses)
    }
}