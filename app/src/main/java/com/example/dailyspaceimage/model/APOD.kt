package com.example.dailyspaceimage.model

import java.time.LocalDate

data class APOD(
    val date: LocalDate,
    val explanation: String,
    val hdUrl: String,
    val url: String,
    val mediaType: String,
    val serviceVersion: String,
    val title: String,
    val copyright: String = ""
) {
    constructor(date: String, explanation: String, hdUrl: String, url: String, mediaType: String,
        serviceVersion: String, title: String) :
            this(LocalDate.parse(date), explanation, hdUrl, url, mediaType, serviceVersion, title)
}
