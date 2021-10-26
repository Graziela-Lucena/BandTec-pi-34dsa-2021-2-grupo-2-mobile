package com.example.justgeek_base_app.data

class ResponseData<T> (
    val data: T? = null,
    val throwable: Throwable? = null,
    val state: ResponseState
)

enum class ResponseState {
    DATA, LOADING, ERROR
}