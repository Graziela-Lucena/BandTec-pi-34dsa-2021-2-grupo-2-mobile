package com.example.justgeek_base_app

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.CommentReviewAdapter
import com.example.justgeek_base_app.viewmodel.CommentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProductReviewFragment(val productId: Int) : Fragment(R.layout.fragment_product_review) {
    val viewModel: CommentViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
            false)
        val reviews = view.findViewById<RecyclerView>(R.id.recycler_product_reviews)

        reviews.layoutManager = layout
        viewModel.getProductComments(productId).observe(viewLifecycleOwner) {
            data{
                val adapterReview = CommentReviewAdapter(it)
                reviews.adapter = adapterReview
                Log.i("grazi-product", it.toString())
            }
            error { t ->
                Log.i("grazi-product", t.toString())
            }
        }
        PagerSnapHelper().attachToRecyclerView(reviews)
    }
}