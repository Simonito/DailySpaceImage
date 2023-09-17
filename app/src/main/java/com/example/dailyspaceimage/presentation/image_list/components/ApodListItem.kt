package com.example.dailyspaceimage.presentation.image_list.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.example.dailyspaceimage.domain.model.Apod
import java.time.format.DateTimeFormatter

@Composable
fun ApodListItem(apod: Apod, onItemClick: (Apod) -> Unit) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.primaryContainer))
            .padding(5.dp)
            .fillMaxWidth()
            .clickable { onItemClick(apod) }
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        /* FIXME: rework the image to have a more unified UI by scaling or cropping the images */
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(apod.url)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .border(BorderStroke(2.dp, Color.Black))
                .clip(RoundedCornerShape(10.dp))
                .fillMaxWidth(0.3f),
            contentScale = ContentScale.FillHeight,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = null
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxHeight()
                .border(BorderStroke(2.dp, Color.Black)),
        ) {
            /* FIXME: the Text elements representing the title, copyright and date may also disturb
             *  the uniformity of our UI. Consider constraining the length of these
             *  (cutting off the lengthy ends), but introduce an option to display the full content
             *  of the Text element */
            Text(
                text = apod.title,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                Text(
                    text = apod.copyright ?: "copyright free",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = apod.date.format(DateTimeFormatter.ISO_DATE),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
