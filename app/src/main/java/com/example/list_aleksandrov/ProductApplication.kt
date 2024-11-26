package com.example.list_aleksandrov

import android.app.Application
import com.example.list_aleksandrov.data.AppContainer
import com.example.list_aleksandrov.data.DefaultAppContainer

class ProductApplication:Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}