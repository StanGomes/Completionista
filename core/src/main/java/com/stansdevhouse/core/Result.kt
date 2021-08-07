package com.stansdevhouse.core

sealed class Result<out T> {
    class Success<out T>(val data: T) : Result<T>()
    class Failure(val errorData: String) : Result<Nothing>()
    object Loading : Result<Nothing>()

    fun handleResult(
        successBlock: (T) -> Unit = {},
        failureBlock: (String) -> Unit = {},
        loading: () -> Unit = {}
    ) {
        when (this) {
            is Success -> successBlock(data)
            is Failure -> failureBlock(errorData)
            is Loading -> loading()
        }
    }
}
