package com.example.dailyspaceimage.presentation.single_image

import com.example.dailyspaceimage.domain.model.Apod

data class SingleApodState(
    val isLoading: Boolean = false,
    val apod: Apod? = null,
    val error: String = ""
)
