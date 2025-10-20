package com.example.testapp.presentation.model

import com.example.testapp.domain.model.User

/**
 * UI state holder for list screen
 */
data class UserListUiState(
    val isLoading: Boolean = true,
    val users: List<User> = emptyList(),
    val error: String? = null
)