package com.stansdevhouse.game_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.stansdevhouse.db.entities.GameDetails
import com.stansdevhouse.ui.HtmlTextView
import com.stansdevhouse.ui.rememberFlowWithLifecycle

@Composable
fun GameDetailsScreen(gameDetailViewModel: GameDetailViewModel) {
    val gameDetails by rememberFlowWithLifecycle(flow = gameDetailViewModel.gameDetails)
        .collectAsState(initial = GameDetails())

    HtmlTextView(text = gameDetails.description)
}
