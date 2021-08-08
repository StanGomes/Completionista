package com.stansdevhouse.domain.usecase

import com.stansdevhouse.core.UseCaseWithParams
import com.stansdevhouse.data.repository.ExploreRepository
import com.stansdevhouse.domain.mappers.GameDetailsResponseToGameDetails
import com.stansdevhouse.domain.model.GameDetails
import javax.inject.Inject

class ShowGameDetailsUseCase @Inject constructor(
    private val exploreRepository: ExploreRepository,
    private val gameDetailsResponseToGameDetails: GameDetailsResponseToGameDetails
) :
    UseCaseWithParams<GameDetails, ShowGameDetailsUseCase.Params>() {

    override suspend fun doWork(params: Params): GameDetails {
        return gameDetailsResponseToGameDetails.map(exploreRepository.getGameDetails(params.gameId))
    }

    data class Params(val gameId: Int)
}