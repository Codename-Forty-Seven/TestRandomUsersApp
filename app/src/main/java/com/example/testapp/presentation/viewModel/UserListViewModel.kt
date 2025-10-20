package com.example.testapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.model.User
import com.example.testapp.domain.useCases.GetUsersUseCase
import com.example.testapp.presentation.model.UserListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


private const val TAG = "UserListViewModel"

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsers: GetUsersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UserListUiState())
    val state: StateFlow<UserListUiState> = _state

    init {
        // Fetch immediately on VM creation
        refresh()
    }

    fun refresh() {
        Log.d(TAG, "refresh()")
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            getUsers().collect { result ->
                result.fold(
                    onSuccess = { list ->
                        Log.d(TAG, "refresh onSuccess: $list")
                        // If success with empty list, we assume still loading just ended
                        _state.value = UserListUiState(
                            isLoading = false,
                            users = list
                        )
                    },
                    onFailure = { t ->
                        t.printStackTrace()
                        Log.d(TAG, "refresh onFailure: ${t.message}")

                        _state.value = UserListUiState(
                            isLoading = false,
                            users = emptyList(),
                            error = t.message ?: "Unknown error"
                        )
                    }
                )
            }
        }
    }
}