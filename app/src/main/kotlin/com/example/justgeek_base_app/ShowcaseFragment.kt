package com.example.justgeek_base_app

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.justgeek_base_app.data.ShowcaseItem

class ShowcaseFragment: Fragment(R.layout.fragment_showcase) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listItems: List<ShowcaseItem> = listOf(
            ShowcaseItem(
                R.drawable.background_showcase,
                "Suas ideias, nosso traço",
                "Customize suas roupas como quiser"
            ),
            ShowcaseItem(
                R.drawable.bg_showcase_category,
                "Categorias - Em Alta",
                "Que tal um mar de variedades?"
            ),
            ShowcaseItem(
                R.drawable.bg_showcase_promo,
                "Promoções da semana",
                "Confira os produtos disponíveis"
            ),
            ShowcaseItem(
                R.drawable.bg_showcase_faq,
                "FAQ - Suporte",
                "Precisa de uma ajudinha?"
            ),
            ShowcaseItem(
                R.drawable.bg_showcase_partner,
                "Seja um parceiro",
                "Faça parte da nossa equipe de artistas"
            ),
        )
        val adapterShowcase = ShowcaseAdapter(listItems)
        val layoutManagerShowcase = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        val showcase = view.findViewById<RecyclerView>(R.id.showcase)
        showcase.adapter = adapterShowcase
        showcase.layoutManager = layoutManagerShowcase

        PagerSnapHelper().attachToRecyclerView(showcase)

    }
}