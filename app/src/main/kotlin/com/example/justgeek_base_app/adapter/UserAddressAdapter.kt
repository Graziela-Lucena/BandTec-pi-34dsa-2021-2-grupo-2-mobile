package com.example.justgeek_base_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.data.UserAddressData

class UserAddressAdapter(val userAddressAdapter : List<UserAddressData>) : RecyclerView.Adapter<UserAddressViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAddressViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_account_config_address_item, parent, false)
        return UserAddressViewHolder(itemView)
    }

    override fun getItemCount(): Int = userAddressAdapter.size

    override fun onBindViewHolder(holder: UserAddressViewHolder, position: Int) {
        val current = userAddressAdapter[position]

        holder.userName.text = current.userName
        holder.userStreet.text = current.userStreet
        holder.userNumberHome.text = current.userStreet
        holder.userNeighborhood.text = current.userNeighborhood
        holder.userCity.text = current.userCity
        holder.userCep.text = current.userCep
    }
}

class UserAddressViewHolder(val itemView : View) : RecyclerView.ViewHolder(itemView) {
    val userName : AppCompatTextView = itemView.findViewById(R.id.user_name)
    val userStreet : AppCompatTextView = itemView.findViewById(R.id.title_street_name)
    val userNumberHome : AppCompatTextView = itemView.findViewById(R.id.title_number_home)
    val userNeighborhood : AppCompatTextView = itemView.findViewById(R.id.title_neighborhood)
    val userCity : AppCompatTextView = itemView.findViewById(R.id.title_city)
    val userCep : AppCompatTextView = itemView.findViewById(R.id.title_cep)
}