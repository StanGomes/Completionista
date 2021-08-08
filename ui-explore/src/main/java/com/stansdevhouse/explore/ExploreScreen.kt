package com.stansdevhouse.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.stansdevhouse.ui.*

@ExperimentalMaterialApi
@ExperimentalUnitApi
@ExperimentalPagerApi
@Composable
fun ExploreScreen(exploreViewModel: ExploreViewModel, openShowDetails: (Long) -> Unit) {

    val viewState by rememberFlowWithLifecycle(flow = exploreViewModel.viewState).collectAsState(
        ExploreViewState()
    )

    if (viewState.loading) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Toolbar(title = "Explore", iconClick = { })
        if (viewState.topGames.isNotEmpty()) {
            val topGames = viewState.topGames
            val pagerState = rememberPagerState(
                pageCount = topGames.size,
                initialOffscreenLimit = 3
            )
            HorizontalCarouselWithTransition(
                pagerState = pagerState
            ) { pageNum, modifier ->
                val game = topGames[pageNum]
                CarouselCardNormal(
                    modifier = modifier,
                    onClick = { openShowDetails(game.id) },
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

