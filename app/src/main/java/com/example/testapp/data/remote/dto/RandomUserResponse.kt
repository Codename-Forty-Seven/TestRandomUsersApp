package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * These mirror the randomuser.me JSON structure succinctly
  */
@JsonClass(generateAdapter = true) // generate Moshi adapter
data class RandomUserResponse(
    @Json(name = "results") val results: List<UserDto>
)