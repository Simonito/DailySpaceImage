package com.example.dailyspaceimage.presentation.image_list

import com.example.dailyspaceimage.domain.model.Apod

data class ApodListState(
    val isLoading: Boolean = false,
    val apods: List<Apod> = emptyList(),
    val error: String = ""
)
