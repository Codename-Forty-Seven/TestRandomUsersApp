package com.example.testapp.data.repository

import android.util.Log
import com.example.testapp.data.mappers.toDomain
import com.example.testapp.data.remote.api.RandomUserApi
import com.example.testapp.domain.model.User
import com.example.testapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "UserRepository"

class UserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi
) : UserRepository {

    // Simple in-memory cache so details screen can re-read by id
    private val cache = LinkedHashMap<String, User>()

    override fun getUsers(): Flow<Result<List<User>>> = flow {
        Log.d(TAG, "getUsers()")
        // Emit loading first
        emit(Result.success(emptyList()))
        try {
            val response = api.getUsers(20)

            Log.d(TAG, "response: $response")

            val users = response.results.map { it.toDomain() }
            // Refresh cache
            cache.clear()
            users.forEach { cache[it.id] = it }
            emit(Result.success(users))
        } catch (t: Throwable) {
            emit(Result.failure(t))
        }
    }

    override fun getCachedUser(id: String): User? = cache[id]
}