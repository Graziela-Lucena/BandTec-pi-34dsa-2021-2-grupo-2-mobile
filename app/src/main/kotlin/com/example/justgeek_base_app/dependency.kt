package com.example.justgeek_base_app

import com.example.justgeek_base_app.repository.ProductRepository
import com.example.justgeek_base_app.repository.UserRepository
import com.example.justgeek_base_app.retrofit.RetrofitJustgeek
import com.example.justgeek_base_app.viewmodel.ProductViewModel
import com.example.justgeek_base_app.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val justGeekModule = module {
    single { RetrofitJustgeek.retrofit() }
    single { RetrofitJustgeek.user(get()) }
    single { UserRepository(get()) }
    single { RetrofitJustgeek.product(get()) }
    single { ProductRepository(get()) }
    viewModel { UserViewModel(get()) }
    viewModel { ProductViewModel(get()) }
}