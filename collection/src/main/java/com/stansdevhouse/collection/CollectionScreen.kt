package com.stansdevhouse.collection

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.stansdevhouse.ui.CarouselCardNormal
import com.stansdevhouse.ui.SmallCarouselTitle
import com.stansdevhouse.ui.Toolbar

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
fun CollectionScreen(collectionViewModel: CollectionViewModel = viewModel()) {

    val inProgressGames by remember {
        collectionViewModel.inProgressGames
    }.collectAsState()

    val pagerState =
        rememberPagerState(pageCount = inProgressGames.size, initialOffscreenLimit = 3)

    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(title = "Collection", iconClick = { })
        Spacer(modifier = Modifier.height(8.dp))
        if (inProgressGames.isNullOrEmpty()) {
            SmallCarouselTitle(title = "No games in progress. Search for something and add it to your library!")
        } else {
            HorizontalPager(state = pagerState) { page ->
                CarouselCardNormal(
                    title = inProgressGames[page].title,
                    imageUrl = "https://media.rawg.io/media/games/84d/84da2ac3fdfc6507807a1808595afb12.jpg"
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
@Preview
fun CollectionScreenPreview() {
    CollectionScreen()
}