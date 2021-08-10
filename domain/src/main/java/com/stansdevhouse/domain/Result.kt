package com.stansdevhouse.domain

sealed class Result<out T> {
    class Success<out T>(val data: T) : Result<T>()
    class Failure(val errorData: String) : Result<Nothing>()
    object Loading : Result<Nothing>()

    fun handleResult(
        onLoading: () -> Unit = {},
        onFailure: (String) -> Unit = {},
        onSuccess: (T) -> Unit = {}
    ) {
        when (this) {
            is Success -> onSuccess(data)
            is Failure -> onFailure(errorData)
            is Loading -> onLoading()
        }
    }
}
