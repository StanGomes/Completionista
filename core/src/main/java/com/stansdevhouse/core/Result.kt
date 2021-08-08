package com.stansdevhouse.core

sealed class Result<out T> {
    class Success<out T>(val data: T) : Result<T>()
    class Failure(val errorData: String) : Result<Nothing>()
    object Loading : Result<Nothing>()

    fun handleResult(
        onSuccess: (T) -> Unit = {},
        onFailure: (String) -> Unit = {},
        onLoading: () -> Unit = {}
    ) {
        when (this) {
            is Success -> onSuccess(data)
            is Failure -> onFailure(errorData)
            is Loading -> onLoading()
        }
    }
}
