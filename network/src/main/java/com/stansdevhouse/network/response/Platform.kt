package com.stansdevhouse.network.response


import com.google.gson.annotations.SerializedName

data class Platform(
    @SerializedName("platform")
    val platform: PlatformDetail,
    @SerializedName("released_at")
    val releasedAt: String,
    @SerializedName("requirements_en")
    val requirementsEn: Any,
    @SerializedName("requirements_ru")
    val requirementsRu: Any
)