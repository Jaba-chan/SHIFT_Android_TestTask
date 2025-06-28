package ru.evgenykuzakov.domain.repository

import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.model.UserMainInfo

interface DefaultUserRepository {

    fun getUsers(): List<UserMainInfo>

    fun getUserDetailInfo(user: UserMainInfo): User

    fun refreshUsers(): Unit

}