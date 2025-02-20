package ru.anura.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.anura.core.network.ApiService
import ru.anura.core.network.RetrofitClient
import javax.inject.Qualifier

@Module
object NetworkModule {
    @Provides
    @CoreScope
    @Retrofit1
    fun provideRetrofit1(): Retrofit {
        return RetrofitClient.retrofitServer1
    }
    @Provides
    @CoreScope
    @Retrofit2
    fun provideRetrofit2(): Retrofit {
        return RetrofitClient.retrofitServer2
    }
    @Provides
    @CoreScope
    fun provideApiService1(@Retrofit1 retrofit: Retrofit): ApiService.ApiService1 {
        return retrofit.create(ApiService.ApiService1::class.java)
    }
    @Provides
    @CoreScope
    fun provideApiService2(@Retrofit2 retrofit: Retrofit): ApiService.ApiService2 {
        return retrofit.create(ApiService.ApiService2::class.java)
    }
}
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Retrofit1

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Retrofit2