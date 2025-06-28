package ru.evgenykuzakov.database.dao

import androidx.room.Dao
import androidx.room.Query
import ru.evgenykuzakov.database.model.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * from users")
    fun getAllUsers(): List<UserEntity>

}