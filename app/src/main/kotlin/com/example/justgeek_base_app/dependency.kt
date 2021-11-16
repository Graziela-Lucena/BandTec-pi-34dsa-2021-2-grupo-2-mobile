package com.example.justgeek_base_app

import com.example.justgeek_base_app.repository.UserRepository
import com.example.justgeek_base_app.retrofit.RetrofitUser
import com.example.justgeek_base_app.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val justGeekModule = module {
    single { RetrofitUser.retrofit() }
    single { RetrofitUser.user(get()) }
    single { UserRepository(get()) }
    viewModel { UserViewModel(get()) }
}