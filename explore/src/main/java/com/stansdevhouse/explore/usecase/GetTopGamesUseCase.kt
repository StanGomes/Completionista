package com.stansdevhouse.explore.usecase

import com.stansdevhouse.core.UseCase
import com.stansdevhouse.explore.ExploreRepository
import com.stansdevhouse.network.response.GamesResultResponse
import javax.inject.Inject

class GetTopGamesUseCase @Inject constructor(private val exploreRepository: ExploreRepository) :
    UseCase<List<GamesResultResponse>>() {

    override suspend fun doWork(): List<GamesResultResponse> {
        return exploreRepository.getTopGames()
    }
}