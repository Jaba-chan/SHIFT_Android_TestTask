package ru.evgenykuzakov.domain.repository

import ru.evgenykuzakov.domain.model.UserDetail
import ru.evgenykuzakov.domain.model.UserMainInfo

interface UsersDataRepository {

    fun getUsers(): List<UserMainInfo>
    fun getUserDetailInfo(): UserDetail

}