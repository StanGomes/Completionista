package com.stansdevhouse.game_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stansdevhouse.core.Argument
import com.stansdevhouse.data.entities.GameDetails
import com.stansdevhouse.domain.usecase.ShowGameDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val showGameDetailsUseCase: ShowGameDetailsUseCase
) : ViewModel() {

    private val _gameDetails: MutableStateFlow<GameDetails> =
        MutableStateFlow(GameDetails(description = ""))
    internal val gameDetails: StateFlow<GameDetails> =
        _gameDetails.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            GameDetails(description = "")
        )


    init {
        val gameId = savedStateHandle.get<Long>(Argument.ARG_GAME_ID) ?: 0
        viewModelScope.launch {
            showGameDetailsUseCase(ShowGameDetailsUseCase.Params(gameId = gameId))
                .collect {
                    it.handleResult { gameDetails ->
                        _gameDetails.value = gameDetails
                    }
                }
        }

    }

}