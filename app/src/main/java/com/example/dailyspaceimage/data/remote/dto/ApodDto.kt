package com.example.dailyspaceimage.data.remote.dto

import com.example.dailyspaceimage.domain.model.Apod
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class ApodDto(
    val date: String,
    val explanation: String,
    @SerializedName("hdurl")
    val hdUrl: String,
    val url: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    val title: String,
    val copyright: String? = ""
)

fun ApodDto.toApod(): Apod {
    return Apod(LocalDate.parse(date), explanation, url, title, copyright)
}
