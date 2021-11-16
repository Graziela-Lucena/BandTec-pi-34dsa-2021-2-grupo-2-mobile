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

class ProfileOrderAdapter(private val profileOrderAdapter: List<OrderData>) : RecyclerView.Adapter<ProfileOrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileOrderViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_profile_orders_item, parent, false)
        return ProfileOrderViewHolder(itemView)
    }

    override fun getItemCount(): Int = profileOrderAdapter.size

    override fun onBindViewHolder(holder: ProfileOrderViewHolder, position: Int) {
        val current = profileOrderAdapter[position]

        Picasso.get().load(current.imageOrder).into(holder.imageOrder)
        holder.dateOrder.text = current.dateOrder
        holder.statusOrder.text = current.statusOrder
    }
}

class ProfileOrderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageOrder = itemView.findViewById<AppCompatImageView>(R.id.image_order)
    val dateOrder = itemView.findViewById<AppCompatTextView>(R.id.title_order_release)
    val statusOrder = itemView.findViewById<AppCompatTextView>(R.id.title_status_order)
}