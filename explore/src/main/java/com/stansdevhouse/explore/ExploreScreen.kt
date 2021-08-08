package com.stansdevhouse.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
fun ExploreScreen(exploreViewModel: ExploreViewModel = viewModel()) {

    val viewState by remember {
        exploreViewModel.viewState
    }.collectAsState()

    if (viewState.loading) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(title = "Explore", iconClick = { })
        if (viewState.topGames.isNotEmpty()) {
            val topGames = viewState.topGames
            val pagerState =
                rememberPagerState(pageCount = topGames.size, initialOffscreenLimit = 3)
            HorizontalPager(
                state = pagerState,
                itemSpacing = 16.dp
            ) { page ->
                val game = topGames[page]
                CarouselCardNormal(
                    onClick = { id ->
                        exploreViewModel.onCardClicked(id)
                    },
                    id = game.id,
                    title = game.title,
                    imageUrl = game.imageUrl
                )
            }
        }
        if (viewState.error.isNotBlank()) {
            SmallCarouselTitle(title = (viewState.error))
        }
    }
}