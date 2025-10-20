package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class StreetDto(
    @Json(name = "number") val number: Int,
    @Json(name = "name") val name: String
)