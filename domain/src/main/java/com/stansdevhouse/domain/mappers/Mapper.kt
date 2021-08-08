package com.stansdevhouse.domain.mappers

interface Mapper<F, T> {
    suspend fun map(from: F): T
}