package ru.anura.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val BASE_URL_1 = "https://dummyjson.com/"
    private const val BASE_URL_2 = "https://dummyjson.com/"

    private fun createRetrofitInstance(baseUrl: String): Retrofit {
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val retrofitServer1: Retrofit by lazy { createRetrofitInstance(BASE_URL_1) }
    val retrofitServer2: Retrofit by lazy { createRetrofitInstance(BASE_URL_2) }
}