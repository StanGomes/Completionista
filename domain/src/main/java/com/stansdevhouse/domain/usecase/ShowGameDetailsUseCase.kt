package com.stansdevhouse.domain.usecase

import com.stansdevhouse.core.UseCaseWithParams
import com.stansdevhouse.data.repository.ExploreRepository
import com.stansdevhouse.network.response.GameDetailsResponse
import javax.inject.Inject

class ShowGameDetailsUseCase @Inject constructor(private val exploreRepository: ExploreRepository) :
    UseCaseWithParams<GameDetailsResponse, ShowGameDetailsUseCase.Params>() {

    override suspend fun doWork(params: Params): GameDetailsResponse {
        return exploreRepository.getGameDetails(params.gameId)
    }

    data class Params(val gameId: Int)
}