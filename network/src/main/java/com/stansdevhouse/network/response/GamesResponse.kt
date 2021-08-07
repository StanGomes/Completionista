package com.stansdevhouse.network.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(
    @SerializedName("next")
    val next: String,
    @SerializedName("results")
    val games: List<GamesResultResponse>
)
