package com.stansdevhouse.explore

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stansdevhouse.db.entities.Game
import com.stansdevhouse.domain.usecase.GetTopGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ExploreViewState(
    val loading: Boolean = false,
    val error: String = "",
    val topGames: List<Game> = emptyList()
)

@HiltViewModel
class ExploreViewModel @Inject constructor(
    getTopGamesUseCase: GetTopGamesUseCase
) : ViewModel() {

    var uiState by mutableStateOf(ExploreViewState())
        private set

    init {
        viewModelScope.launch {
            getTopGamesUseCase()
                .onEach {
                    it.handleResult(
                        onSuccess = { gamesResult ->
                            uiState = ExploreViewState(topGames = gamesResult)
                        },
                        onFailure = { errorString ->
                            uiState = ExploreViewState(error = errorString)
                        },
                        onLoading = {
                            uiState = ExploreViewState(loading = true)
                        }
                    )
                }.collect()
        }
    }
}