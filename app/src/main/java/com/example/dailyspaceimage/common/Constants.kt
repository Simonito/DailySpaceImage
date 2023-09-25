package com.example.dailyspaceimage.common

import com.example.dailyspaceimage.BuildConfig

object Constants {
    const val APOD_BASE_URL = "https://api.nasa.gov/"
    const val API_KEY = BuildConfig.API_KEY

    object Dates {
        const val END = "end_date"
        const val START = "start_date"
        const val PARTICULAR = "date"
        const val LATEST = "latest_apod_date"
    }
}