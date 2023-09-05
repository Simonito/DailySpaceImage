package com.example.dailyspaceimage.data.remote.dto

import com.example.dailyspaceimage.domain.model.Apod
import com.google.gson.annotations.SerializedName
import java.time.LocalDate

data class ApodDto(
    val date: LocalDate,
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
) {
    constructor(date: String, explanation: String, hdUrl: String, url: String, mediaType: String,
        serviceVersion: String, title: String) :
            this(LocalDate.parse(date), explanation, hdUrl, url, mediaType, serviceVersion, title)
}

fun ApodDto.toApod(): Apod {
    return Apod(date, explanation, url, title, copyright)
}
