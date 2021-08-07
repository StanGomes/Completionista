package com.stansdevhouse.explore

import com.stansdevhouse.network.RawgApiService
import com.stansdevhouse.network.response.GamesResultResponse
import javax.inject.Inject

class ExploreRepositoryImpl @Inject constructor(private val rawgApiService: RawgApiService) :
    ExploreRepository {
    override suspend fun getTopGames(): List<GamesResultResponse> =
        rawgApiService.getAllGames().games

}