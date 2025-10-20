package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class TimezoneDto(
    @Json(name = "offset") val offset: String,
    @Json(name = "description") val description: String
)