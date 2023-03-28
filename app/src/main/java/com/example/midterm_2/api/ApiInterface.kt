package com.example.midterm_2.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/?inc=nat,name,email&results=10")
    suspend fun getUsers(): Response<Users>
}