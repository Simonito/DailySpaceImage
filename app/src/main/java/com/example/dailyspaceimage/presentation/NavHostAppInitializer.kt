package com.example.dailyspaceimage.presentation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dailyspaceimage.presentation.image_list.ApodListScreen
import com.example.dailyspaceimage.presentation.image_list.ApodListViewModel
import com.example.dailyspaceimage.presentation.single_image.SingleApodScreen
import com.example.dailyspaceimage.presentation.single_image.SingleApodViewModel

@Composable
fun NavHostAppInitializer(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ApodListScreen.route
    ) {
        composable(
            route = Screen.ApodListScreen.route
        ) {
            ApodListScreen(
                navController,
                viewModel(factory = ApodListViewModel.Factory)
            )
        }
        composable(
            route = Screen.SingleApodScreen.route + "/{apodDate}"
        ) {
            SingleApodScreen(
                navController,
                viewModel(factory = SingleApodViewModel.Factory)
            )
        }
    }
}