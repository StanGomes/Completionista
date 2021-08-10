package com.stansdevhouse.domain.usecase

import com.stansdevhouse.data.entities.Game
import com.stansdevhouse.data.mappers.GamesResultResponseToGame
import com.stansdevhouse.data.repository.ExploreRepository
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