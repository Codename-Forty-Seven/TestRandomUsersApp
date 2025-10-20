package com.example.testapp.domain.repository

import com.example.testapp.domain.model.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    // Fetch 20 users from API and expose as Flow (emits Loading -> Success/Error)
    fun getUsers(): Flow<Result<List<User>>>

    // Get a single user from in-memory cache by id (used on details screen)
    fun getCachedUser(id: String): User?
}