package ru.evgenykuzakov.data.repository

import ru.evgenykuzakov.data.util.toDomain
import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.repository.RemoteUserRepository
import ru.evgenykuzakov.network.RandomUserApi
import javax.inject.Inject

class RemoteUserRepositoryImpl @Inject constructor(
    private val api: RandomUserApi
) : RemoteUserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().results.map { it.toDomain() }
    }
}