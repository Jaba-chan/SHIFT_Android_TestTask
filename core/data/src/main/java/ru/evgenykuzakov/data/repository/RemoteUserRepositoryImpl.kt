package ru.evgenykuzakov.data.repository

import ru.evgenykuzakov.data.util.toDomain
import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.repository.RemoteUserRepository
import ru.evgenykuzakov.network.RandomUserApi

class RemoteUserRepositoryImpl(
    private val api: RandomUserApi
) : RemoteUserRepository {
    override suspend fun getUsers(): List<User> {
        return api.getUsers().map { it.toDomain() }
    }
}