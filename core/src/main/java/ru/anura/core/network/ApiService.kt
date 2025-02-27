package ru.anura.core.network

import retrofit2.http.GET
import retrofit2.http.Path
import ru.anura.core.entity.Product

class ApiService {
    interface ApiService1 {
        @GET("products/{id}")
        suspend fun getProductById(@Path("id") id: Int): Product
    }

    interface ApiService2 {
        @GET("products/{id}")
        suspend fun getProductById(@Path("id") id: Int): Product
    }
}
