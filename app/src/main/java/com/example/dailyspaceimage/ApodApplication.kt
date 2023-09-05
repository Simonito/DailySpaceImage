package com.example.dailyspaceimage

import android.app.Application
import com.example.dailyspaceimage.di.AppModule
import com.example.dailyspaceimage.di.AppModuleImpl

class ApodApplication : Application() {
    companion object {
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()
        appModule = AppModuleImpl(this)
    }
}
