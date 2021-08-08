package com.stansdevhouse.domain.mappers

import com.stansdevhouse.domain.model.Game
import com.stansdevhouse.network.response.GamesResultResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GamesResultResponseToGame @Inject constructor() : Mapper<GamesResultResponse, Game> {
    override suspend fun map(from: GamesResultResponse) = Game(
        title = from.name,
        id = from.id,
        imageUrl = from.backgroundImage
    )
}