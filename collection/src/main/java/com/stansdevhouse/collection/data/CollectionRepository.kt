package com.stansdevhouse.collection.data

import com.stansdevhouse.data.CarouselGame
import kotlinx.coroutines.flow.Flow

interface CollectionRepository {
    fun getInProgressGames(): Flow<List<CarouselGame>>
}