package com.example.suitmediatest.data.network.service

import com.example.suitmediatest.data.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(USER)
    suspend fun getUserPaging(
        @Query("page") page: Int? = default_page
    ) : UserResponse

    companion object{
        const val USER = "users"
        const val default_page = 1
    }
}