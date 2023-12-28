package com.example.suitmediatest.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.suitmediatest.data.network.response.DataItem
import com.example.suitmediatest.data.network.service.ApiService
import com.example.suitmediatest.data.paging.UserPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository{
    override fun getUserPaging(): Flow<PagingData<DataItem>> = Pager(
        config = PagingConfig(pageSize = 3, enablePlaceholders = false),
        pagingSourceFactory = { UserPagingSource(apiService) }
    ).flow

}