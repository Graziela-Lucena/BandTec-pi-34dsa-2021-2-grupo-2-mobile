package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.OrderItemConfirmation
import com.squareup.picasso.Picasso

class MyCartOrderConfirmationAdapter(private val myCartOrderConfirmationAdapter: List<OrderItemConfirmation>)
    : RecyclerView.Adapter<MyCartOrderConfirmationViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyCartOrderConfirmationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_my_cart_order_confirmation_item, parent, false)
        return MyCartOrderConfirmationViewHolder(itemView)
    }

    override fun getItemCount(): Int = myCartOrderConfirmationAdapter.size

    override fun onBindViewHolder(holder: MyCartOrderConfirmationViewHolder, position: Int) {
        val current = myCartOrderConfirmationAdapter[position]

        Picasso.get().load(current.imageOrderConfirmation).into(holder.imageOrderConfirmation)
        holder.titleQuantityChosen.text = current.titleQuantityChosen
    }
    }

class MyCartOrderConfirmationViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val imageOrderConfirmation : AppCompatImageView = itemView.findViewById(R.id.image_item_confirmation)
    val titleQuantityChosen : AppCompatTextView = itemView.findViewById(R.id.title_quantity_chosen)
}