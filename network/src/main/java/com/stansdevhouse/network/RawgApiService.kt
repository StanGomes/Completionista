package com.stansdevhouse.network

import com.stansdevhouse.network.response.GamesResponse
import retrofit2.http.GET

interface RawgApiService {
    @GET("games")
    suspend fun getAllGames(): GamesResponse
}