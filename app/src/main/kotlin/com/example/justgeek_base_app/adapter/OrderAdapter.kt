package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.OrderData
import com.squareup.picasso.Picasso

class OrderAdapter(private val orderAdapter: List<OrderData>) : RecyclerView.Adapter<OrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_profile_item, parent, false)
        return OrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = orderAdapter.size

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val current = orderAdapter[position]

        Picasso.get().load(current.imageOrder).into(holder.imageOrder)
        holder.dateOrder.text = current.dateOrder
        holder.statusOrder.text = current.statusOrder
    }
}

class OrderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageOrder : AppCompatImageView = itemView.findViewById(R.id.image_order)
    val dateOrder : AppCompatTextView = itemView.findViewById(R.id.title_date_order)
    val statusOrder : AppCompatTextView = itemView.findViewById(R.id.status_order)
}