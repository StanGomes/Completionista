package com.stansdevhouse.collection

import com.stansdevhouse.collection.data.CollectionRepository
import com.stansdevhouse.collection.data.InProgressGamesUseCase
import com.stansdevhouse.data.CarouselGame
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val inProgressGamesUseCase: InProgressGamesUseCase
) : CollectionRepository {

    override fun getInProgressGames(): Flow<List<CarouselGame>> =
        inProgressGamesUseCase.getInProgressGames
}