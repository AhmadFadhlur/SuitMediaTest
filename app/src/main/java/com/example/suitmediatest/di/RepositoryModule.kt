package com.example.suitmediatest.di

import com.example.suitmediatest.data.repository.UserRepository
import com.example.suitmediatest.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsUserRepository(userRepositoryImpl: UserRepositoryImpl) : UserRepository

}