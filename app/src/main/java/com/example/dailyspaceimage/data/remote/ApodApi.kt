package com.example.dailyspaceimage.data.remote

import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.data.remote.dto.ApodDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {
    @GET("/planetary/apod")
    suspend fun getApods(
        @Query("api_key") apiKey: String,
        @Query(Constants.Dates.END) endDate: String,
        @Query(Constants.Dates.START) startDate: String): List<ApodDto>

    @GET("/planetary/apod")
    suspend fun getSingleApod(
        @Query("api_key") apiKey: String,
        @Query(Constants.Dates.PARTICULAR) date: String): ApodDto

    @GET("/planetary/apod")
    suspend fun getLatestApod(@Query("api_key") apiKey: String): ApodDto
}
