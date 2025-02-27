package ru.anura.feature_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val factory: HomeViewModel.Factory
) : ViewModelProvider.Factory {
    private var testValue: String? = null

    fun setTestValue(testValue: String) {
        this.testValue = testValue
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            if (testValue == null) throw IllegalStateException("testValue не был установлен")
            return factory.create(testValue!!) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}