package ru.anura.core.di

import dagger.Component
import ru.anura.core.network.ApiService
import ru.anura.core.repositoryImpl.RepositoryImpl

@Component(modules = [NetworkModule::class])
@CoreScope
interface CoreComponent {
    fun inject(repositoryImpl: RepositoryImpl)

    fun apiService1(): ApiService.ApiService1
    fun apiService2(): ApiService.ApiService2


    @Component.Factory
    interface Factory {
        fun create(): CoreComponent
    }
}