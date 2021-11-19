package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.CouponData
import com.squareup.picasso.Picasso

class CouponAdapter (private val couponAdapter: List<CouponData>)
    : RecyclerView.Adapter<CouponViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CouponViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_my_coupons_item, parent, false)
        return CouponViewHolder(itemView)
    }

    override fun getItemCount(): Int = couponAdapter.size

    override fun onBindViewHolder(holder: CouponViewHolder, position: Int) {
        val current = couponAdapter[position]

        holder.price.text = current.price.toString()
        holder.divider.text = current.divider
        holder.code.text = current.code
    }
    }

class CouponViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val price : AppCompatTextView = itemView.findViewById(R.id.title_less_price)
    val divider : AppCompatTextView = itemView.findViewById(R.id.divider_coupon)
    val code : AppCompatTextView = itemView.findViewById(R.id.title_code_coupon)
}