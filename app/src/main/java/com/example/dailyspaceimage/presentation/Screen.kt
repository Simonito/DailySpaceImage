package com.example.dailyspaceimage.presentation

sealed class Screen(val route: String) {
    object ApodListScreen: Screen("apod_list_screen")
    object SingleApodScreen: Screen("single_apod_screen")
}
