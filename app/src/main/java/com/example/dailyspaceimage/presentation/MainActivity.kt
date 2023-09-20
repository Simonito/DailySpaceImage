package com.example.dailyspaceimage.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailyspaceimage.presentation.image_list.ApodListScreen
import com.example.dailyspaceimage.presentation.image_list.ApodListViewModel
import com.example.dailyspaceimage.presentation.single_image.SingleApodScreen
import com.example.dailyspaceimage.presentation.single_image.SingleApodViewModel
import com.example.dailyspaceimage.presentation.theme.DailySpaceImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailySpaceImageTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
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
            }
        }
    }
}
