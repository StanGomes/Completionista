package com.stansdevhouse.explore

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.stansdevhouse.ui.CarouselCardNormal
import com.stansdevhouse.ui.HorizontalCarouselWithTransition
import com.stansdevhouse.ui.Toolbar
import com.stansdevhouse.ui.rememberFlowWithLifecycle
import kotlinx.coroutines.launch

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

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(viewState) {
        if (viewState.error.isNotBlank()) {
            scope.launch {
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

