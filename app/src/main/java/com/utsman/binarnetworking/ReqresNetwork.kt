package com.utsman.binarnetworking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ReqresNetwork {
    private const val BASE_URL = "https://reqres.in"

    fun retrofit(): ReqresWebServices {
        val gsonConverter = GsonConverterFactory.create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverter)
            .build()
            .create(ReqresWebServices::class.java)
    }
}