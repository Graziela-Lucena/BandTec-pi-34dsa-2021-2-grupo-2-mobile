package com.example.justgeek_base_app

class ResponseData<T> (
    val data: T? = null,
    val throwable: Throwable? = null,
    val state: ResponseState
)

enum class ResponseState {
    DATA, LOADING, ERROR
}