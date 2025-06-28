package ru.evgenykuzakov.domain.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import ru.evgenykuzakov.common.Resource
import ru.evgenykuzakov.domain.model.User
import ru.evgenykuzakov.domain.model.UserMainInfo
import ru.evgenykuzakov.domain.repository.DefaultUserRepository
import javax.inject.Inject

class GetUserDetailInfoUseCase @Inject constructor(
    private val repository: DefaultUserRepository
) {
    operator fun invoke(user: UserMainInfo): Flow<Resource<User>> = flow{
        emit(Resource.Loading())
        emit(Resource.Success(repository.getUserDetailInfo(user)))
    }.catch { e ->
        println("GetUserDetailInfoUseCase" + e.message)
        emit(Resource.Error(message = e.message))
    }.flowOn(Dispatchers.IO)
}