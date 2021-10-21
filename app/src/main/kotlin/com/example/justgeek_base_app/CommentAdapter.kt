package com.example.justgeek_base_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CommentAdapter(private val commentList: List<CommentItem>):  RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.showcase_item, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
//        val currentItem = commentList[position]
//        holder.name.text = currentItem.name
//        holder.comment.text = currentItem.comment
//        holder.rate.text = currentItem.rate.toString()
    }

    override fun getItemCount(): Int = commentList.size
}

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val name: TextView = itemView.findViewById()
//    val comment: TextView = itemView.findViewById()
//    val rate: TextView = itemView.findViewById()
}
