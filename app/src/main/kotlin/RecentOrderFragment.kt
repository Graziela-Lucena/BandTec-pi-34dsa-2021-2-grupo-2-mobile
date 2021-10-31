import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.R
import com.example.justgeek_base_app.adapter.OrderAdapter
import com.example.justgeek_base_app.data.OrderData

class RecentOrderFragment:Fragment(R.layout.fragment_profile_recent_orders) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listRecentOrders : List<OrderData> = listOf(
            OrderData(
                R.drawable.popular1,
                getString(R.string.title_date_recent_order),
                getString(R.string.title_my_order_waiting_payment)
            )
        )

        val adapterRecentOrder = OrderAdapter(listRecentOrders)
        val layoutManagerRecentOrder = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        val recentOrder = view.findViewById<RecyclerView>(R.id.recycler_orders)
        recentOrder.adapter = adapterRecentOrder
        recentOrder.layoutManager = layoutManagerRecentOrder

        PagerSnapHelper().attachToRecyclerView(recentOrder)
    }
}