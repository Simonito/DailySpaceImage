package com.example.dailyspaceimage.domain.model

import java.time.LocalDate

data class Apod(
    val date: LocalDate,
    val explanation: String,
    val url: String,
    val title: String,
    val copyright: String? = ""
)
