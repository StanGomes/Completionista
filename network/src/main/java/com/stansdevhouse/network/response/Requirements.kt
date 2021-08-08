package com.stansdevhouse.network.response


import com.google.gson.annotations.SerializedName

data class Requirements(
    @SerializedName("minimum")
    val minimum: String,
    @SerializedName("recommended")
    val recommended: String
)