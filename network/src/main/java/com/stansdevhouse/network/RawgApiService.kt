package com.stansdevhouse.network

import com.stansdevhouse.network.response.GameDetailsResponse
import com.stansdevhouse.network.response.GamesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RawgApiService {
    @GET("games")
    suspend fun getAllGames(): GamesResponse

    @GET("games/{id}")
    suspend fun getGameById(@Path("id") id: Long): GameDetailsResponse
}