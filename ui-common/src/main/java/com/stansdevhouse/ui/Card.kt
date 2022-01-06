package com.stansdevhouse.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CarouselCardNormal(
    modifier: Modifier = Modifier,
    title: String,
    imageUrl: String,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colorScheme.surface,
        elevation = 8.dp
    ) {
        Box {
            Image(
                painter = rememberImagePainter(imageUrl),
                modifier = Modifier.fillMaxSize(),
                contentDescription = title,
                contentScale = ContentScale.Crop,
                alpha = 0.4f
            )
            SmallCarouselTitle(
                title = title,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
fun CarouselCardNormalPreview() {
    CarouselCardNormal(
        title = "Counter Strike: Global Offensive somme more ",
        imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg",
        onClick = {}
    )
}