package com.stansdevhouse.collection.data

import com.stansdevhouse.data.CarouselGame
import kotlinx.coroutines.flow.Flow

interface InProgressGamesUseCase {
    val getInProgressGames: Flow<List<CarouselGame>>
}