package ru.evgenykuzakov.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.evgenykuzakov.network.RandomUserApi
import javax.inject.Singleton

private const val BASE_URL = "https://randomuser.me/api"

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideRandomUserApi(): RandomUserApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomUserApi::class.java)
    }

}