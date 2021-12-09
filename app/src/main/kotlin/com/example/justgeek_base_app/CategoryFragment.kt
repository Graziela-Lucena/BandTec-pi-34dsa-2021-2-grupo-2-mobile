package com.example.justgeek_base_app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.ProductCategoryAdapter
import org.koin.android.viewmodel.ext.android.viewModel
import com.example.justgeek_base_app.viewmodel.CategoryViewModel

class CategoryFragment : Fragment(R.layout.fragment_category) {
    val categoryProductViewModel : CategoryViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val showcase = view.findViewById<RecyclerView>(R.id.recycler_category)
        val layoutManagerCategory = GridLayoutManager(requireContext(), 2)
        showcase.layoutManager = layoutManagerCategory

        PagerSnapHelper().attachToRecyclerView(showcase)

        categoryProductViewModel.getAllProducts().observe(viewLifecycleOwner) {
            data {
                val adapterCategory = ProductCategoryAdapter(it)
                showcase.adapter = adapterCategory
                Log.i("Taiza", it.toString())
            }
        }
    }
}