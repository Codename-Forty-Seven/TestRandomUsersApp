package com.example.testapp.data.remote.api

import com.example.testapp.data.remote.dto.RandomUserResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface RandomUserApi {
    // Returns 20 results by default as per requirements
    @GET("api/")
    suspend fun getUsers(@Query("results") results: Int = 20): RandomUserResponse
}