package com.example.testapp.presentation.navigation


/**
 * Simple route constants for Navigation Compose
 */
object NavRoutes {
    const val USER_LIST = "user_list"
    const val USER_DETAILS = "user_details"
    const val ARG_USER_ID = "userId"
    const val USER_DETAILS_ROUTE = "$USER_DETAILS/{$ARG_USER_ID}"
}