package ru.evgenykuzakov.domain.repository

import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.model.UserMainInfo

interface LocalUsersRepository {

    fun getUsers(): List<UserMainInfo>
    fun getUserDetailInfo(): User

}