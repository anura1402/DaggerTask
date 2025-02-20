package ru.anura.core.domain

interface Repository {
    suspend fun fetchDataFromServer1():String
    suspend fun fetchDataFromServer2():String
}