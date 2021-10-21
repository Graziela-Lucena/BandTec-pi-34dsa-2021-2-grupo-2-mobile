package com.example.justgeek_base_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ShowcaseAdapter(private val showcaseNews: List<ShowcaseItem>) : RecyclerView.Adapter<ShowcaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowcaseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.showcase_item, parent, false)
        return ShowcaseViewHolder(itemView)
    }

    override fun getItemCount(): Int = showcaseNews.size

    override fun onBindViewHolder(holder: ShowcaseViewHolder, position: Int) {
        val currentItem = showcaseNews[position] as ShowcaseItem

        Picasso.get().load(currentItem.background).into(holder.background)
        holder.title.text = currentItem.title
        holder.subtitle.text = currentItem.subtitle

    }
}

class ShowcaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val background: ImageView = itemView.findViewById(R.id.background_showcase)
    var title: TextView = itemView.findViewById(R.id.title_showcase)
    var subtitle: TextView = itemView.findViewById(R.id.subtitle_showcase)
}
