package com.example.testapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.testapp.domain.repository.UserRepository
import com.example.testapp.presentation.model.UserDetailsUiState
import com.example.testapp.presentation.navigation.NavRoutes
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "UserDetailsViewModel"

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val repository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val state: UserDetailsUiState

    init {
        Log.d(TAG, "init()")
        // Extract the nav argument and lookup in cache
        val id = savedStateHandle.get<String>(NavRoutes.ARG_USER_ID)
        val user = id?.let { repository.getCachedUser(it) }
        state = if (user != null) {
            UserDetailsUiState(user = user)
        } else {
            UserDetailsUiState(error = "User not found in cache. Go back and try again.")
        }
    }
}