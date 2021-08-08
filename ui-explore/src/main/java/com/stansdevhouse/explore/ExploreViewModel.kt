package com.stansdevhouse.explore

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stansdevhouse.domain.model.Game
import com.stansdevhouse.domain.usecase.GetTopGamesUseCase
import com.stansdevhouse.domain.usecase.ShowGameDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ExploreViewState(
    val loading: Boolean = false,
    val error: String = "",
    val topGames: List<Game> = emptyList()
)

@HiltViewModel
class ExploreViewModel @Inject constructor(
    getTopGamesUseCase: GetTopGamesUseCase,
    private val showGameDetailsUseCase: ShowGameDetailsUseCase
) : ViewModel() {

    private val _viewState: MutableStateFlow<ExploreViewState> =
        MutableStateFlow(ExploreViewState())
    internal val viewState: StateFlow<ExploreViewState> =
        _viewState.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), ExploreViewState())

    init {
        viewModelScope.launch {
            getTopGamesUseCase()
                .onEach {
                    it.handleResult(
                        onSuccess = { gamesResult ->
                            _viewState.value = ExploreViewState(topGames = gamesResult)
                        },
                        onFailure = { errorString ->
                            _viewState.value = ExploreViewState(error = errorString)
                        },
                        onLoading = {
                            _viewState.value = ExploreViewState(loading = true)
                        }
                    )
                }.collect()
        }
    }

    fun onCardClicked(id: Int) {
        viewModelScope.launch {
            showGameDetailsUseCase(params = ShowGameDetailsUseCase.Params(gameId = id))
                .onEach {
                    it.handleResult(
                        onSuccess = { gameDetails ->
                            Log.d("STANSTAN", "onCardClicked: ${gameDetails.description}")
                        }
                    )
                }
                .collect()
        }
    }
}