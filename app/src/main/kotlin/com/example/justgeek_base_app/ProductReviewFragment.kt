package com.example.justgeek_base_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.CommentReviewAdapter
import com.example.justgeek_base_app.data.CommentReview

class ProductReviewFragment : Fragment(R.layout.fragment_product_review) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listReviews : List<CommentReview> = mutableListOf(
            CommentReview(
                getString(R.string.title_client_name),
                getString(R.string.text_comment_client)
            ),
            CommentReview(
                getString(R.string.title_client_name),
                getString(R.string.text_comment_client)
            ),
            CommentReview(
                getString(R.string.title_client_name),
                getString(R.string.text_comment_client)
            ),
        )

        val adapterReview = CommentReviewAdapter(listReviews)
        val layout = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,
            false)
        val reviews = view.findViewById<RecyclerView>(R.id.recycler_product_reviews)

        reviews.adapter = adapterReview
        reviews.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(reviews)
    }
}