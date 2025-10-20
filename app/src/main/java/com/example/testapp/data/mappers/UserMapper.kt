package com.example.testapp.data.mappers

import com.example.testapp.data.remote.dto.UserDto
import com.example.testapp.domain.model.User


/**
 * Converts DTO to domain model, normalizing fields
 */
fun UserDto.toDomain(): User {
    val streetLine = "${location.street.number} ${location.street.name}"
    val postcodeStr = when (val pc = location.postcode) {
        is Number -> pc.toString()
        is String -> pc
        else -> ""
    }
    return User(
        id = login.uuid,
        title = name.title,
        firstName = name.first,
        lastName = name.last,
        email = email,
        phone = phone,
        cell = cell,
        pictureLarge = picture.large,
        pictureThumb = picture.thumbnail,
        street = streetLine,
        city = location.city,
        state = location.state,
        country = location.country,
        postcode = postcodeStr,
        nat = nat,
        dateOfBirthIso = dob.date
    )
}