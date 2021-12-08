package com.example.justgeek_base_app

import com.example.justgeek_base_app.repository.*
import com.example.justgeek_base_app.retrofit.RetrofitJustgeek
import com.example.justgeek_base_app.viewmodel.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val justGeekModule = module {
    single { RetrofitJustgeek.retrofit() }
    single { RetrofitJustgeek.user(get()) }
    single { UserRepository(get()) }
    single { RetrofitJustgeek.product(get()) }
    single { RetrofitJustgeek.comment(get()) }
    single { RetrofitJustgeek.category(get()) }
    single { RetrofitJustgeek.popularArtists(get()) }
    single { ProductRepository(get()) }
    single { CommentRepository(get()) }
    single { CategoryRepository(get()) }
    single { ArtistRepository(get()) }
    viewModel { UserViewModel(get()) }
    viewModel { ProductViewModel(get()) }
    viewModel { CommentViewModel(get()) }
    viewModel { CategoryViewModel(get()) }
    viewModel { ArtistViewModel(get()) }
}