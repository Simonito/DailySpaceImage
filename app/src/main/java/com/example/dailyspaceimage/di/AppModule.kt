package com.example.dailyspaceimage.di

import android.content.Context
import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.data.remote.ApodApi
import com.example.dailyspaceimage.data.repo.ApodRepoImpl
import com.example.dailyspaceimage.domain.repo.ApodRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

interface AppModule {
    val apodApi: ApodApi
    val apodRepository: ApodRepo
}

class AppModuleImpl(
    private val appContext: Context,
): AppModule {
    override val apodApi: ApodApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.APOD_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    override val apodRepository: ApodRepo by lazy {
        ApodRepoImpl(apodApi)
    }
}