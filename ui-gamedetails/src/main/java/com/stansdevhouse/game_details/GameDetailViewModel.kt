package com.stansdevhouse.game_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stansdevhouse.core.Argument
import com.stansdevhouse.db.entities.GameDetails
import com.stansdevhouse.domain.usecase.ShowGameDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val showGameDetailsUseCase: ShowGameDetailsUseCase
) : ViewModel() {

    var gameDetails by mutableStateOf(GameDetails())
        private set

    init {
        val gameId = savedStateHandle.get<Long>(Argument.ARG_GAME_ID) ?: 0
        viewModelScope.launch {
            showGameDetailsUseCase(ShowGameDetailsUseCase.Params(gameId = gameId))
                .collect {
                    it.handleResult { result ->
                        gameDetails = result
                    }
                }
        }
    }
}