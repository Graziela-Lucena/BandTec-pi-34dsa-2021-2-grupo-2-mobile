package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.CommentItem
import com.example.justgeek_base_app.data.CommentReview

class CommentReviewAdapter (private val itemCommentReview : List<CommentItem>)
    : RecyclerView.Adapter<CommentReviewViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentReviewViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_product_review,
                parent, false)
            return CommentReviewViewHolder(itemView)
        }

    override fun getItemCount(): Int = itemCommentReview.size

    override fun onBindViewHolder(holder: CommentReviewViewHolder, position: Int) {
            val current = itemCommentReview[position]
            holder.userName.text = current.name
            holder.commentReview.text = current.comment
        }
    }

class CommentReviewViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView) {
    val userName = itemView.findViewById<AppCompatTextView>(R.id.user_name_comment_review)
    val commentReview = itemView.findViewById<AppCompatTextView>(R.id.text_comment_review)
}