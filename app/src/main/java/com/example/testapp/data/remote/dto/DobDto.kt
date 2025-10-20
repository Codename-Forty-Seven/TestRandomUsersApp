package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class DobDto(
    @Json(name = "date") val date: String, // e.g. 1973-12-23T01:17:32.925Z
    @Json(name = "age") val age: Int
)