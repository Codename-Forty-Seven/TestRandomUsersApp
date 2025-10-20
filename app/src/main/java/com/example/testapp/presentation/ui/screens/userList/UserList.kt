package com.example.testapp.presentation.ui.screens.userList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testapp.domain.model.User


@Composable
fun UserList(
    users: List<User>,
    onUserClick: (String) -> Unit
) {
    // LazyColumn to display 20 users
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(users, key = { it.id }) { user ->
            UserRow(user = user, onClick = { onUserClick(user.id) })
        }
    }
}