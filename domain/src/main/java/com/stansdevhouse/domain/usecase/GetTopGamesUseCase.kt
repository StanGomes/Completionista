package com.stansdevhouse.domain.usecase

import com.stansdevhouse.core.UseCase
import com.stansdevhouse.data.repository.ExploreRepository
import com.stansdevhouse.domain.mappers.GamesResultResponseToGame
import com.stansdevhouse.domain.model.Game
import javax.inject.Inject

class GetTopGamesUseCase @Inject constructor(
    private val exploreRepository: ExploreRepository,
    private val gamesResultResponseToGame: GamesResultResponseToGame,
) : UseCase<List<Game>>() {

    override suspend fun doWork(): List<Game> {
        return exploreRepository.getTopGames().map {
            gamesResultResponseToGame.map(it)
        }
    }
}