package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true) // generate Moshi adapter
data class LocationDto(
    @Json(name = "street") val street: StreetDto,
    @Json(name = "city") val city: String,
    @Json(name = "state") val state: String,
    @Json(name = "country") val country: String,
    // Postcode can be Int or String -> use Any
    @Json(name = "postcode") val postcode: Any,
    @Json(name = "coordinates") val coordinates: CoordinatesDto? = null,
    @Json(name = "timezone") val timezone: TimezoneDto? = null
)