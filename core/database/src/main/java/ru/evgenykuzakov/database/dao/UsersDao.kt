package ru.evgenykuzakov.database.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.evgenykuzakov.database.model.UserEntity

@Dao
interface UsersDao {

    @Query("SELECT * from users")
    fun getAllUsers(): Flow<List<UserEntity>>

}