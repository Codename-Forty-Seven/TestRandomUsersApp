package com.example.testapp.domain.useCases

import com.example.testapp.domain.model.User
import com.example.testapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(): Flow<Result<List<User>>> = repository.getUsers()
}