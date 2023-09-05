package com.example.dailyspaceimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.unit.dp
import com.example.dailyspaceimage.repo.TestingAPODRepo
import com.example.dailyspaceimage.presentation.theme.DailySpaceImageTheme
import com.example.dailyspaceimage.presentation.image_list.components.Item

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailySpaceImageTheme {
                val repo = TestingAPODRepo()
                val testingData = repo.getDefaultAPODs()
                
                LazyColumn(
                    contentPadding = PaddingValues(all = 5.dp),
                    verticalArrangement = Arrangement.spacedBy(7.dp)
                ) {
                    items(items = testingData) {apod ->
                        Item(apod)
                    }
                }
            }
        }
    }
}
