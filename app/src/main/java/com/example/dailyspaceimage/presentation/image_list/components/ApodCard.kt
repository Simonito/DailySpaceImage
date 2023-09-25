package com.example.dailyspaceimage.presentation.image_list.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter

private object CardConstants {
}

private const val superLongText = "We calculate the lineHeight in pixels based on the font size. You can adjust the font size as needed." +
        "We create a Box composable to contain both the Text and the gradient background." +
        "We use the animateContentSize modifier to animate the content size change when the expanded state changes." +
        "We calculate the gradientStartY position based on the lineHeight and set it initially to be slightly above the text. You can adjust the starting position as needed." +
        "We use a vertical gradient as the background for the Box with the gradientStartY and height calculated based on the expanded state." +
        "With these modifications, the gradient background will start slightly above the text and adjust its position based on the number of lines when the text is expanded."

@Composable
fun ApodCard(
    painter: AsyncImagePainter,
    description: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box {
            Image(
                painter = painter,
                contentDescription = description,
                contentScale = ContentScale.Crop
            )
            TitleText(
                title = title,
                modifier = Modifier
                    .align(Alignment.BottomStart)
            )
        }
    }
}

@Composable
private fun TitleText(
    title: String,
    modifier: Modifier = Modifier
) {
    val lineHeight = with(LocalDensity.current) {
        MaterialTheme.typography.titleSmall.lineHeight.toPx()
    }
    val textPadding = 8.dp

    var parentSize by remember { mutableStateOf(IntSize(0, 0)) }
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .animateContentSize()
        .onPlaced { coordinates ->
            parentSize = IntSize(
                width = coordinates.size.width,
                height = coordinates.size.height
            )
        }
        .background(
            if (expanded)
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                        MaterialTheme.colorScheme.background.copy(alpha = 0.6f)
                    ),
                    startY = 0f
                )
            else
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        MaterialTheme.colorScheme.primaryContainer
                    ),
                    startY = parentSize.height - 3 * (lineHeight + textPadding.value)
                )
        )
    )
    Text(
        text = if (title.startsWith("Arp 142:")) superLongText else title,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
            .clickable { expanded = !expanded }
            .padding(
                horizontal = textPadding,
                vertical = textPadding / 2
            )
            .fillMaxWidth()
            .animateContentSize(),
        color = MaterialTheme.colorScheme.onPrimaryContainer,
        overflow = if (expanded) TextOverflow.Visible else TextOverflow.Ellipsis,
        maxLines = if (expanded) Int.MAX_VALUE else 1,
        fontWeight = FontWeight.Normal
    )
}
