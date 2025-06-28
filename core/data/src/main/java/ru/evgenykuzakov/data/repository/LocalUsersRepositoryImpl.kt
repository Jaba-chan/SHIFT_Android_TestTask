package ru.evgenykuzakov.data.repository

import ru.evgenykuzakov.data.util.toDomain
import ru.evgenykuzakov.data.util.toEntity
import ru.evgenykuzakov.data.util.toUserMainInfo
import ru.evgenykuzakov.database.dao.UsersDao
import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.model.UserMainInfo
import ru.evgenykuzakov.domain.repository.LocalUsersRepository

class LocalUsersRepositoryImpl(
    private val dao: UsersDao
) : LocalUsersRepository {

    override suspend fun getUsers(): List<UserMainInfo> {
        return dao.getAllUsers().map { it.toUserMainInfo() }
    }

    override suspend fun getUserDetailInfo(user: UserMainInfo): User {
        return dao.getUser(user.id).toDomain()
    }

    override suspend fun clearAll() {
        dao.clearAll()
    }

    override suspend fun insertAll(users: List<User>) {
        dao.insertAll(users.map { it.toEntity() })
    }
}