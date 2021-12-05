package com.example.justgeek_base_app

<<<<<<< Updated upstream
import androidx.fragment.app.Fragment

class CommentFragment: Fragment() {
=======
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.CommentAdapter
import com.example.justgeek_base_app.viewmodel.CommentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CommentFragment: Fragment(R.layout.fragment_comment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel: CommentViewModel by viewModel()

        val showcase = view.findViewById<RecyclerView>(R.id.recycler_comment)
        val layoutManagerComment = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        showcase.layoutManager = layoutManagerComment

        PagerSnapHelper().attachToRecyclerView(showcase)

        viewModel.getHomeComments().observe(viewLifecycleOwner){
            data {
                val adapterComment = CommentAdapter(it)
                showcase.adapter = adapterComment
                Log.i("grazi", it.toString())
            }
            error { t ->
                Log.i("grazi", t.toString())
            }
        }
    }
>>>>>>> Stashed changes
}