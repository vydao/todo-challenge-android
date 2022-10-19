package com.huumai.challengeandroid.api

import retrofit2.Response
import com.huumai.challengeandroid.api.data.Result

abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            }
            return Result.Failure(
                msg = response.code().toString() + " " + response.message().toString()
            )
        } catch (e: Exception) {
            return Result.Failure(msg = e.message.toString())
        }
    }
}