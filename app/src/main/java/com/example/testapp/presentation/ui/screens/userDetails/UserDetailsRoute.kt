package com.example.testapp.presentation.ui.screens.userDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testapp.presentation.viewModel.UserDetailsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsRoute(
    onBack: () -> Unit,
    viewModel: UserDetailsViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(state.user?.fullName ?: "User") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize()) {
            when {
                state.error != null -> Text(
                    text = state.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp)
                )
                state.user != null -> UserDetailsContent(state.user)
            }
        }
    }
}