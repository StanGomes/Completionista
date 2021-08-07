package com.stansdevhouse.network

import com.stansdevhouse.network.response.GamesResponse
import retrofit2.http.GET

interface RawgApiService {
    @GET("games?key=ac55c6cdd31d47908a149e15a191e71a")
    suspend fun getAllGames(): GamesResponse
}