package com.stansdevhouse.explore.di

import com.stansdevhouse.explore.ExploreRepository
import com.stansdevhouse.explore.ExploreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ExploreModule {

//        getTopGamesUseCaseImpl

    //    @Provides
//    @Singleton
//    fun providesGetTopGamesUseCase(getTopGamesUseCaseImpl: GetTopGamesUseCaseImpl): GetTopGamesUseCase =
    @Singleton
    @Binds
    abstract fun providesExploreRepository(exploreRepositoryImpl: ExploreRepositoryImpl): ExploreRepository

}