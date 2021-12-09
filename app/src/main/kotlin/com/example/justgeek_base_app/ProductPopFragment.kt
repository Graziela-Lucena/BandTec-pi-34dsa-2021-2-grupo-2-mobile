package com.example.justgeek_base_app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductPopAdapter
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductPopFragment: Fragment(R.layout.fragment_popular) {
    val productViewModel: ProductViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val showcase = view.findViewById<RecyclerView>(R.id.recycler_promo)
        val layoutManagerPromo = GridLayoutManager(requireContext(), 2)
        showcase.layoutManager = layoutManagerPromo

        PagerSnapHelper().attachToRecyclerView(showcase)

        productViewModel.getPopularProduct().observe(viewLifecycleOwner) {
            data {
                val adapterPromo = ProductPopAdapter(it)
                showcase.adapter = adapterPromo
                Log.i("grazi", it.toString())
            }
            error { t ->
                Log.i("grazi", t.toString())
            }
        }

    }
}


