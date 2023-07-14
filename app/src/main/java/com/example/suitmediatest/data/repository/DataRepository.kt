package com.example.suitmediatest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.suitmediatest.data.paging.UserPagingSource
import com.example.suitmediatest.network.model.user.DataItem
import com.example.suitmediatest.network.service.ApiService
import java.util.concurrent.Flow

class DataRepository(private val apiService: ApiService) {

    fun getUser () : kotlinx.coroutines.flow.Flow<PagingData<DataItem>> =
        Pager(
            config = PagingConfig(pageSize = 3, enablePlaceholders = false),
            pagingSourceFactory = { UserPagingSource(apiService)}
        ).flow

}