package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class RegisteredDto(
    @Json(name = "date") val date: String,
    @Json(name = "age") val age: Int
)