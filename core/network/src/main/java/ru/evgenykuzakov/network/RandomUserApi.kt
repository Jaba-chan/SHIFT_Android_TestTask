package ru.evgenykuzakov.network

import retrofit2.http.GET
import ru.evgenykuzakov.network.model.UserDto

interface RandomUserApi {

    @GET("/?results=100?")
    suspend fun getUsers(): List<UserDto>

}