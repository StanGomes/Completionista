package com.stansdevhouse.explore

import com.stansdevhouse.network.RawgApiService
import com.stansdevhouse.network.response.GamesResultResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExploreRepository @Inject constructor(private val rawgApiService: RawgApiService) {
    suspend fun getTopGames(): List<GamesResultResponse> =
        rawgApiService.getAllGames().games

}