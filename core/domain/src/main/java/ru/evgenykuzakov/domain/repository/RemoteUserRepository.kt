package ru.evgenykuzakov.domain.repository

import ru.evgenykuzakov.domain.model.User

interface RemoteUserRepository {

    fun getUsers(): List<User>

}