package com.stansdevhouse.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.rememberPagerState
import com.stansdevhouse.ui.CarouselCardNormal
import com.stansdevhouse.ui.HorizontalCarouselWithTransition
import com.stansdevhouse.ui.Toolbar
import com.stansdevhouse.ui.rememberFlowWithLifecycle
import kotlinx.coroutines.launch

@Composable
fun ExploreScreen(exploreViewModel: ExploreViewModel, openShowDetails: (Long) -> Unit) {

    val viewState by rememberFlowWithLifecycle(flow = exploreViewModel.viewState).collectAsState(
        ExploreViewState()
    )

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(viewState) {
        if (viewState.error.isNotBlank()) {
            launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    viewState.error,
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    Scaffold(
        topBar = {
            Toolbar(title = "Explore", iconClick = { })
        },
        scaffoldState = scaffoldState,
    ) {
        if (viewState.loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        }
        Column(modifier = Modifier.fillMaxSize()) {
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
        }
    }
}

