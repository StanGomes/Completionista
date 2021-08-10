package com.stansdevhouse.game_details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.stansdevhouse.data.entities.GameDetails
import com.stansdevhouse.ui.rememberFlowWithLifecycle

@Composable
fun GameDetailsScreen(gameDetailViewModel: GameDetailViewModel) {
    val gameDetails by rememberFlowWithLifecycle(flow = gameDetailViewModel.gameDetails)
        .collectAsState(initial = GameDetails(description = ""))

    Text(text = gameDetails.description)
}
