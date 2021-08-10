package com.stansdevhouse.data.mappers

import com.stansdevhouse.data.entities.GameDetails
import com.stansdevhouse.network.response.GameDetailsResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GameDetailsResponseToGameDetails @Inject constructor() :
    Mapper<GameDetailsResponse, GameDetails> {
    override suspend fun map(from: GameDetailsResponse) = GameDetails(
        description = from.description
    )
}