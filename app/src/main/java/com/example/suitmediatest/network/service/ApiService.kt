package com.example.suitmediatest.network.service

import com.example.suitmediatest.network.model.user.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(USER)
    suspend fun getUser(
        @Query("page") page: Int? = default_page
    ) : UserResponse


    companion object{
        const val USER = "users"
        const val default_page = 1
    }
}