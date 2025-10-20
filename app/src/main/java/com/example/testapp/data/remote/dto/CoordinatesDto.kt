package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class CoordinatesDto(
    @Json(name = "latitude") val latitude: String,
    @Json(name = "longitude") val longitude: String
)