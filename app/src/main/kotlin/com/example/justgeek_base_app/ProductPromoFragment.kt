package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.data.ProductItem

class ProductPromoFragment: Fragment(R.layout.fragment_promotions) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listItems: List<ProductItem> = mutableListOf(
            ProductItem(
                "20%",
                "Camiseta Naruto",
                "R$ 65.00",
                "RS 80.00",
                R.drawable.popular1
            ),
            ProductItem(
                "20%",
                "Camiseta Naruto",
                "R$ 65.00",
                "RS 80.00",
                R.drawable.popular1
            ),
            ProductItem(
                "20%",
                "Camiseta Naruto",
                "R$ 65.00",
                "RS 80.00",
                R.drawable.popular1
            ),
            ProductItem(
                "20%",
                "Camiseta Naruto",
                "R$ 65.00",
                "RS 80.00",
                R.drawable.popular1
            ),
            ProductItem(
                "20%",
                "Camiseta Naruto",
                "R$ 65.00",
                "RS 80.00",
                R.drawable.popular1
            ),
        )
        val adapterPromo = ProductAdapter(listItems)
        val layoutManagerPromo = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val showcase = view.findViewById<RecyclerView>(R.id.recycler_promo)
        showcase.adapter = adapterPromo
        showcase.layoutManager = layoutManagerPromo

        PagerSnapHelper().attachToRecyclerView(showcase)
    }
}