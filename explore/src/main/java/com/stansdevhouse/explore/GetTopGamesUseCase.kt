package com.stansdevhouse.explore

import com.stansdevhouse.core.UseCase
import com.stansdevhouse.network.response.GamesResultResponse
import javax.inject.Inject

class GetTopGamesUseCase @Inject constructor(private val exploreRepository: ExploreRepository) :
    UseCase<List<GamesResultResponse>>() {

    override suspend fun doWork(): List<GamesResultResponse> {
        return exploreRepository.getTopGames()
    }
}