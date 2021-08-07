package com.stansdevhouse.collection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stansdevhouse.collection.data.CollectionRepository
import com.stansdevhouse.data.CarouselGame
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CollectionViewModel @Inject constructor(
    collectionRepository: CollectionRepository
) : ViewModel() {

    internal val inProgressGames: StateFlow<List<CarouselGame>> = collectionRepository
        .getInProgressGames()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), listOf())
}