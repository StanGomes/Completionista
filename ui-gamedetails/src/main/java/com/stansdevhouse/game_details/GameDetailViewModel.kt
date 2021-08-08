package com.stansdevhouse.game_details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.stansdevhouse.core.Argument
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {

    init {
        Log.d(
            "STANSTAN",
            "GameDetailViewModel id: ${savedStateHandle.get<Int>(Argument.ARG_GAME_ID)}"
        )
    }

}