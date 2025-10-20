package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true) // generate Moshi adapter
data class PictureDto(
    @Json(name = "large") val large: String,
    @Json(name = "medium") val medium: String?,
    @Json(name = "thumbnail") val thumbnail: String
)