package com.stansdevhouse.data

import androidx.room.Entity

@Entity(tableName = "InProgress")
data class CarouselGame(val title: String, val imageUrl: String)
