package com.example.justgeek_base_app

<<<<<<< Updated upstream
import com.example.justgeek_base_app.repository.UserRepository
import com.example.justgeek_base_app.retrofit.RetrofitUser
=======
import com.example.justgeek_base_app.repository.CommentRepository
import com.example.justgeek_base_app.repository.ProductRepository
import com.example.justgeek_base_app.repository.UserRepository
import com.example.justgeek_base_app.retrofit.RetrofitJustgeek
import com.example.justgeek_base_app.viewmodel.CommentViewModel
import com.example.justgeek_base_app.viewmodel.ProductViewModel
>>>>>>> Stashed changes
import com.example.justgeek_base_app.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val justGeekModule = module {
    single { RetrofitUser.retrofit() }
    single { RetrofitUser.user(get()) }
    single { UserRepository(get()) }
<<<<<<< Updated upstream
    viewModel { UserViewModel(get()) }
=======
    single { RetrofitJustgeek.product(get()) }
    single { RetrofitJustgeek.comment(get()) }
    single { ProductRepository(get()) }
    single { CommentRepository(get()) }
    viewModel { UserViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { CommentViewModel(get()) }
>>>>>>> Stashed changes
}