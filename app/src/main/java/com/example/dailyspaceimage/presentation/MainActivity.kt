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
import com.example.dailyspaceimage.presentation.image_list.ApodListViewModelFactory
import com.example.dailyspaceimage.presentation.single_image.SingleApodScreen
import com.example.dailyspaceimage.presentation.single_image.SingleApodViewModelFactory
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
                                viewModel(factory = ApodListViewModelFactory())
                            )
                        }
                        composable(
                            route = Screen.SingleApodScreen.route + "/{coinId}"
                        ) {
                            SingleApodScreen(
                                navController,
                                viewModel(factory = SingleApodViewModelFactory())
                            )
                        }
                    }
                }
//                val repo = TestingAPODRepo()
//                val testingData = repo.getDefaultAPODs()
//
//                LazyColumn(
//                    contentPadding = PaddingValues(all = 5.dp),
//                    verticalArrangement = Arrangement.spacedBy(7.dp)
//                ) {
//                    items(items = testingData) {apod ->
//                        ApodListItem(apod.toApod()) { apod.toApod() }
//                    }
//                }
            }
        }
    }
}
