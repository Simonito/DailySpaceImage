package com.example.dailyspaceimage.presentation.image_list

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dailyspaceimage.ApodApplication
import com.example.dailyspaceimage.common.Constants
import com.example.dailyspaceimage.presentation.Screen
import com.example.dailyspaceimage.presentation.image_list.components.ApodListItem
import java.time.format.DateTimeFormatter

@Composable
fun ApodListScreen(
    navController: NavController,
    viewModel: ApodListViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 13.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Log.i("DATE LIST INFO",
                viewModel.state.value
                    .apods
                    .map { a ->
                        a.date.format(DateTimeFormatter.ISO_DATE)}.toString()
            )
            items(items = viewModel.state.value.apods) {apod ->
                Log.i("DATE INFO", apod.date.format(DateTimeFormatter.ISO_DATE))
                ApodListItem(
                    apod = apod,
                    onItemClick = {
                        // modify the date parameter for the getSingleApod use case
                        ApodApplication.appModule.apodDateStateHandle.set(Constants.PARAM_DATE, apod.date)
                        navController.navigate(Screen.SingleApodScreen.route + "/${apod.date}")
                    }
                )
            }
        }
        if (viewModel.state.value.error.isNotBlank()) {
            Text(
                text = viewModel.state.value.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }

        if (viewModel.state.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}
