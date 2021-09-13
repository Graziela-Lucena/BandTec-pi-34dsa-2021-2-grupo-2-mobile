package com.example.justgeek_base_app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JustGeekApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(
                this@JustGeekApplication
            )
            modules (
                justGeekModule
            )
        }
    }
}