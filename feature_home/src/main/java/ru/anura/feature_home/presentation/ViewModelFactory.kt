package ru.anura.feature_home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import ru.anura.feature_home.domain.FetchDataUseCase
import javax.inject.Inject

class ViewModelFactory @AssistedInject constructor(
    private val useCase: FetchDataUseCase,
    @Assisted("testValue") private val testValue: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(useCase, testValue) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    @AssistedFactory
    interface Factory {
        fun create(@Assisted("testValue") testValue: String): ViewModelFactory
    }
}