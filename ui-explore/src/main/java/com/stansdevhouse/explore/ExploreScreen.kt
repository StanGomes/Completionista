package com.stansdevhouse.explore

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.rememberPagerState
import com.stansdevhouse.ui.CarouselCardNormal
import com.stansdevhouse.ui.CompletionistaTheme
import com.stansdevhouse.ui.HorizontalCarouselWithTransition
import com.stansdevhouse.ui.Toolbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(uiState: ExploreViewState, openShowDetails: (Long) -> Unit) {

    Scaffold(
        topBar = {
            Toolbar(title = "Explore", iconClick = { })
        }
    ) {
        if (uiState.loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        LazyColumn {
            item {
                val topGames = uiState.topGames
                val pagerState = rememberPagerState(
                    pageCount = topGames.size,
                    initialOffscreenLimit = 3
                )
                if (topGames.isNotEmpty()) {
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
            }
        }
    }
}

@Preview
@Composable
fun ExploreScreenPreview() {
    CompletionistaTheme {
        ExploreScreen(uiState = ExploreViewState(), openShowDetails = {})
    }
}

