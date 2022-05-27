package com.example.paginationwithpaging3library.network.service

import com.example.paginationwithpaging3library.model.UserData
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("users")
    suspend fun getUsers(@Query("page") page : Int): UserData

}