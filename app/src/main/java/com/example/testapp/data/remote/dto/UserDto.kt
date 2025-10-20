package com.example.testapp.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true) // generate Moshi adapter
data class UserDto(
    @Json(name = "gender") val gender: String?,
    @Json(name = "name") val name: NameDto,
    @Json(name = "location") val location: LocationDto,
    @Json(name = "email") val email: String,
    @Json(name = "login") val login: LoginDto,
    @Json(name = "dob") val dob: DobDto,
    @Json(name = "registered") val registered: RegisteredDto?,
    @Json(name = "phone") val phone: String,
    @Json(name = "cell") val cell: String?,
    @Json(name = "id") val id: IdDto?,
    @Json(name = "picture") val picture: PictureDto,
    @Json(name = "nat") val nat: String?
)