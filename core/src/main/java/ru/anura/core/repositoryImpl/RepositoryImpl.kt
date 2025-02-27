package ru.anura.core.repositoryImpl

import ru.anura.core.domain.Repository
import ru.anura.core.network.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService1: ApiService.ApiService1,
    private val apiService2: ApiService.ApiService2
) : Repository {
    override suspend fun fetchDataFromServer1(): String {
        return apiService1.getProductById(1).toString()
    }

    override suspend fun fetchDataFromServer2(): String {
        return apiService2.getProductById(2).toString()
    }
}