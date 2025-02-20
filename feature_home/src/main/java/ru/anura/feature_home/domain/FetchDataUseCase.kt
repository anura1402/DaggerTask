package ru.anura.feature_home.domain

import android.util.Log
import ru.anura.core.domain.Repository
import javax.inject.Inject

class FetchDataUseCase @Inject constructor(private val repository: Repository) {

    suspend fun executeRequest1(): String {
        Log.d("HomeFragment", "executeRequest1() started")
        return repository.fetchDataFromServer1()
    }

    suspend fun executeRequest2(): String {
        Log.d("HomeFragment", "executeRequest1() started")
        return repository.fetchDataFromServer2()
    }

}