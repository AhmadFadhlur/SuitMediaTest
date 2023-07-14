package com.example.suitmediatest.di

import android.content.Context
import com.example.suitmediatest.data.repository.DataRepository
import com.example.suitmediatest.network.service.ApiConfig

object Injection {
    fun provideRepository(context: Context): DataRepository {
        val apiService = ApiConfig.getApiService()
        return DataRepository(apiService)
    }
}