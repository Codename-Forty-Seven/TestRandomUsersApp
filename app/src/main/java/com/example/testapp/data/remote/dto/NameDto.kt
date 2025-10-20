package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class NameDto(
    @Json(name = "title") val title: String?,
    @Json(name = "first") val first: String,
    @Json(name = "last") val last: String
)