package com.example.testapp.domain.model


/**
 * Domain model kept clean and UI-agnostic
 */

data class User(
    val id: String,              // uuid
    val title: String?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val cell: String?,
    val pictureLarge: String,
    val pictureThumb: String,
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val nat: String?,            // nationality code like NL, MX, CH
    val dateOfBirthIso: String
) {
    val fullName: String get() = listOfNotNull(title, "$firstName $lastName")
        .filter { it.isNotBlank() }
        .joinToString(" ").trim()
    val fullAddress: String get() = "$street, $city, $state, $postcode, $country"
}