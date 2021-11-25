package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.WithoutAddressData

class WithoutAddressAdapter (private val withoutAddressItem: List<WithoutAddressData>)
    : RecyclerView.Adapter<WithoutAddressViewHold>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WithoutAddressViewHold {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_product_shipping_fee_item, parent, false)
        return  WithoutAddressViewHold(itemView)
        }

    override fun getItemCount(): Int = withoutAddressItem.size

    override fun onBindViewHolder(holder: WithoutAddressViewHold, position: Int) {
        val current = withoutAddressItem[position]

        holder.textWithoutAddress.text = current.textWithoutAddress
        holder.textLinkAddAddress.text = current.textLinkAddAddress
        }
    }

class WithoutAddressViewHold(val itemView : View) : RecyclerView.ViewHolder(itemView) {
    val textWithoutAddress : AppCompatTextView = itemView.findViewById(R.id.text_without_address)
    val textLinkAddAddress : AppCompatTextView = itemView.findViewById(R.id.link_add_new_address)
}