package com.example.suitmediatest.di

import com.example.suitmediatest.data.network.service.ApiConfig
import com.example.suitmediatest.data.network.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideUserApiService(): ApiService = ApiConfig.getApiService()

}