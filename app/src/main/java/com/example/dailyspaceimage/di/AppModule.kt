package com.example.dailyspaceimage.di

import android.content.Context
import androidx.lifecycle.SavedStateHandle
import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.data.remote.ApodApi
import com.example.dailyspaceimage.data.repo.ApodRepoImpl
import com.example.dailyspaceimage.domain.repo.ApodRepo
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.time.LocalDate
import java.time.temporal.ChronoUnit

interface AppModule {
    val apodApi: ApodApi
    val apodRepository: ApodRepo
    val apodDateStateHandle: SavedStateHandle
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

    override val apodDateStateHandle: SavedStateHandle by lazy {
        SavedStateHandle(
            mapOf(
                /* FIXME: implement some sort of API call to an online NTP server
                 *  by which we will make sure that the date is correct
                 *  this is applicable to the ApodListViewModel as well,
                 *  so a universal implementation is needed */
                Constants.PARAM_END_DATE to LocalDate.now(),
                Constants.PARAM_START_DATE to LocalDate.now().minus(10, ChronoUnit.DAYS)
            )
        )
    }
}
