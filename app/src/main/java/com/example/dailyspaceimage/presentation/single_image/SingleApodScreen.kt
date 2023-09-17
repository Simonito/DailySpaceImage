package com.example.dailyspaceimage.presentation.single_image

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
import com.example.dailyspaceimage.presentation.Screen
import com.example.dailyspaceimage.presentation.image_list.components.ApodListItem

/* FIXME: A complete rewok of this is needed as it does not work at all */
@Composable
fun SingleApodScreen(
    navController: NavController,
    viewModel: SingleApodViewModel
) {
    val state = viewModel.state.value
    state.apod?.let { stateValApod ->
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(all = 5.dp),
                verticalArrangement = Arrangement.spacedBy(7.dp)
            ) {
                items(items = listOf(stateValApod)) { apod ->
                    ApodListItem(
                        apod = apod,
                        onItemClick = {
                            navController.navigate(Screen.ApodListScreen.route)
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
}
