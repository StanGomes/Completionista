package com.stansdevhouse.collection.di

import com.stansdevhouse.collection.CollectionRepositoryImpl
import com.stansdevhouse.collection.data.CollectionRepository
import com.stansdevhouse.collection.data.InProgressGamesUseCase
import com.stansdevhouse.collection.usecase.InProgressGamesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CollectionModule {

    @Provides
    fun providesInProgressUseCase(inProgressGamesUseCaseImpl: InProgressGamesUseCaseImpl): InProgressGamesUseCase =
        inProgressGamesUseCaseImpl

    @Provides
    fun providesCollectionRepository(collectionRepositoryImpl: CollectionRepositoryImpl): CollectionRepository =
        collectionRepositoryImpl
}