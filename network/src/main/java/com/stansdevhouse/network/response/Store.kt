package com.stansdevhouse.network.response


import com.google.gson.annotations.SerializedName

data class Store(
    @SerializedName("id")
    val id: Int,
    @SerializedName("store")
    val store: StoreDetail,
    @SerializedName("url")
    val url: String
)