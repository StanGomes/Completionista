package com.stansdevhouse.domain.usecase

import com.stansdevhouse.domain.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeout
import java.util.concurrent.TimeUnit

abstract class UseCase<out T> {

    operator fun invoke(timeoutMs: Long = defaultTimeoutMs): Flow<Result<T>> {
        return flow {
            withTimeout(timeoutMs) {
                emit(Result.Loading)
                val data = doWork()
                data?.let {
                    emit(Result.Success(it))
                } ?: run {
                    emit(Result.Failure("Null"))
                }
            }
        }.catch { throwable ->
            emit(Result.Failure(throwable.message ?: "Error fetching"))
        }.flowOn(Dispatchers.IO)
    }

    protected abstract suspend fun doWork(): T?

    companion object {
        private val defaultTimeoutMs = TimeUnit.MINUTES.toMillis(5)
    }
}