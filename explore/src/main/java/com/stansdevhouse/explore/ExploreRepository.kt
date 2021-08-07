package com.stansdevhouse.explore

import com.stansdevhouse.network.response.GamesResultResponse

interface ExploreRepository {
    suspend fun getTopGames(): List<GamesResultResponse>
}