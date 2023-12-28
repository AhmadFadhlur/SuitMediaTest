package com.example.suitmediatest.data.repository

import androidx.paging.PagingData
import com.example.suitmediatest.data.network.response.DataItem
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserPaging() : Flow<PagingData<DataItem>>
}