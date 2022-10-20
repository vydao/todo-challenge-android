package com.huumai.challengeandroid.api.data

import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @POST("users")
    suspend fun createUser(@Body data: JsonObject): ResponseBody

    @POST("users/login")
    suspend fun login(@Body data: JsonObject): ResponseBody

    @GET("users/{id}}")
    suspend fun getUserProfile(@Path("id") id: String): ResponseBody

    @POST("challenges")
    suspend fun createChallenge(@Body data: JsonObject): ResponseBody

    @POST("challenges/{id}}/todos")
    suspend fun createToDo(@Path("id") id: String, @Body data: JsonObject): ResponseBody

    @POST("challenges/{id}}/accept")
    suspend fun acceptChallenge(@Path("id") id: String): ResponseBody

    @GET("challenges/{id}}/todos")
    suspend fun getToDoList(@Path("id") id: String): ResponseBody
}