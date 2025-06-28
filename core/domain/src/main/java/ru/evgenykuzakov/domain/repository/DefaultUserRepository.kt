package ru.evgenykuzakov.domain.repository

import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.model.UserMainInfo

interface DefaultUserRepository {

    suspend fun getUsers(): List<UserMainInfo>

    suspend fun getUserDetailInfo(user: UserMainInfo): User

    suspend fun refreshUsers(): Unit

}