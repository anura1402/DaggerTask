package ru.anura.feature_home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import ru.anura.feature_home.domain.FetchDataUseCase
import javax.inject.Inject

class HomeViewModel @AssistedInject constructor(
    private val useCase: FetchDataUseCase,
    @Assisted private val testValue: String
) : ViewModel() {

    private val _messageLiveData = MutableLiveData<String>()
    val messageLiveData: LiveData<String> = _messageLiveData

    init {
        Log.d("HomeFragment", "HomeViewModel создана с testValue: $testValue")
    }

    fun makeRequests() {
        viewModelScope.launch {
            try {
                val message1 = useCase.executeRequest1()
                val message2 = useCase.executeRequest2()
                _messageLiveData.postValue("$message1\n$message2")
            } catch (e: Exception) {
                _messageLiveData.postValue("Ошибка: ${e.message}")
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(testValue: String): HomeViewModel
    }
}