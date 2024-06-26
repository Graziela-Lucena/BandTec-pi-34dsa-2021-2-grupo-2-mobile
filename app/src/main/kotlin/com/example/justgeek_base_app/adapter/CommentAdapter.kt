package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatRatingBar
import androidx.recyclerview.widget.RecyclerView
import br.com.arch.toolkit.livedata.response.ResponseLiveData
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.CommentItem

class CommentAdapter(private val commentList: List<CommentItem>):  RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
        return CommentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val currentItem = commentList[position]
        holder.name.text = currentItem.name
        holder.comment.text = currentItem.comment
        holder.rate.text = currentItem.rate.toString()
    }

    override fun getItemCount(): Int = commentList.size
}

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.user_name)
    val comment: TextView = itemView.findViewById(R.id.comment)
    val rate: TextView = itemView.findViewById(R.id.rate)
}
