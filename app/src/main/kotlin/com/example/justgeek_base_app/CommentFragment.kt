package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.CommentAdapter
import com.example.justgeek_base_app.data.CommentItem

class CommentFragment: Fragment(R.layout.fragment_comment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listItems: List<CommentItem> = mutableListOf(
            CommentItem(
                "Gisele Flor",
                "Adorei as camisetas, muito confortáveis.",
                0.5F
            ),
            CommentItem(
                "Pedro Rocha",
                "Legal.",
                3.5F
            ),
            CommentItem(
                "Gisele Flor",
                "Adorei as camisetas, muito confortáveis.",
                4.5F
            ),
            CommentItem(
                "Graziela Batista de Lucena Lima",
                "comentário lorem ipsum dolor sit amet é isso ai daora demais. lorem ipsum dolor sit amet",
                5F
            )
        )
        val adapterComment = CommentAdapter(listItems)
        val layoutManagerComment = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val showcase = view.findViewById<RecyclerView>(R.id.recycler_comment)
        showcase.adapter = adapterComment
        showcase.layoutManager = layoutManagerComment

        PagerSnapHelper().attachToRecyclerView(showcase)
    }
}