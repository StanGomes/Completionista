package com.stansdevhouse.game_details

import androidx.compose.runtime.Composable
import com.stansdevhouse.ui.HtmlTextView

@Composable
fun GameDetailsScreen(gameDetailViewModel: GameDetailViewModel) {
    val gameDetails = gameDetailViewModel.gameDetails

    HtmlTextView(text = gameDetails.description)
}
