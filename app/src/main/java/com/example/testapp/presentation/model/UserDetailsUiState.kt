package com.example.testapp.presentation.model

import com.example.testapp.domain.model.User

data class UserDetailsUiState(
    val user: User? = null,
    val error: String? = null
)