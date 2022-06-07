package com.utsman.binarnetworking

import retrofit2.http.GET
import retrofit2.http.Query

interface ReqresWebServices {

// ?page=2

    @GET("/api/users")
    suspend fun getUser(@Query("page") page: Int): ReqresResponse
}