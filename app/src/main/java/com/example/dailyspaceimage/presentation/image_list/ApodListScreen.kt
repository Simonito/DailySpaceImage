package com.example.dailyspaceimage.presentation.image_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dailyspaceimage.presentation.image_list.components.ApodListItem

@Composable
fun ApodListScreen(
    navController: NavController,
    viewModel: ApodListViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(all = 5.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            items(items = viewModel.state.value.apods) {apod ->
                ApodListItem(
                    apod = apod,
                    onItemClick = {

                    }
                )
            }
        }
    }
}