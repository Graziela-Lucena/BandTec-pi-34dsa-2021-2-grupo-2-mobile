package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.adapter.CouponAdapter
import com.example.justgeek_base_app.data.CouponData

class MyCouponsFragment : Fragment(R.layout.fragment_my_coupons) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listCoupons : List<CouponData> = mutableListOf(
           CouponData(
               getString(R.string.title_less_price),
               getString(R.string.divisor),
               getString(R.string.title_code_coupon)
           ),
            CouponData(
                getString(R.string.title_less_price),
                getString(R.string.divisor),
                getString(R.string.title_code_coupon)
            ),
            CouponData(
                getString(R.string.title_less_price),
                getString(R.string.divisor),
                getString(R.string.title_code_coupon)
            ),
            CouponData(
                getString(R.string.title_less_price),
                getString(R.string.divisor),
                getString(R.string.title_code_coupon)
            ),
        )

        val adapter = CouponAdapter(listCoupons)
        val layout = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL, false)

        val coupons = view.findViewById<RecyclerView>(R.id.recycler_coupons)

        coupons.adapter = adapter
        coupons.layoutManager = layout

        PagerSnapHelper().attachToRecyclerView(coupons)
    }
}