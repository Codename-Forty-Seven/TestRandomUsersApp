package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class IdDto(
    @Json(name = "name") val name: String?,
    @Json(name = "value") val value: String?
)