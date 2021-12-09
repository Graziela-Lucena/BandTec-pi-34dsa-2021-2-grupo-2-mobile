package com.example.justgeek_base_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductAdapter
import com.example.justgeek_base_app.adapter.ProductPromotionCartViewHold
import com.example.justgeek_base_app.data.ProductItem
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductPromoFragment: Fragment(R.layout.fragment_promotions) {
    val viewModel: ProductViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManagerPromo = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val showcase = view.findViewById<RecyclerView>(R.id.recycler_promo)
        showcase.layoutManager = layoutManagerPromo
        PagerSnapHelper().attachToRecyclerView(showcase)
        viewModel.getPromotionalProduct().observe(viewLifecycleOwner) {
            data {
                val adapterPromo = ProductAdapter(it) {
                    val intent = Intent(requireContext(), ProductActivity::class.java)
                    intent.putExtra("idProductExtra", it.idProduto)
                    startActivity(intent)
                }
                showcase.adapter = adapterPromo
            }
        }
    }
}