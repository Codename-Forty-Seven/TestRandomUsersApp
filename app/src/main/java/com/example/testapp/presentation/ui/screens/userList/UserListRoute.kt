package com.example.testapp.presentation.ui.screens.userList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testapp.presentation.viewModel.UserListViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListRoute(
    onUserClick: (String) -> Unit,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Random Users") })
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            when {
                state.isLoading -> Loading()
                state.error != null -> ErrorView(
                    message = state.error ?: "Error",
                    onRetry = { viewModel.refresh() }
                )
                else -> UserList(
                    users = state.users,
                    onUserClick = onUserClick
                )
            }
        }
    }
}