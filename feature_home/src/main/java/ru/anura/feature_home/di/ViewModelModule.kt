package ru.anura.feature_home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.anura.feature_home.presentation.HomeViewModel
import ru.anura.feature_home.presentation.ViewModelFactory

@Module
object  ViewModelModule {
    @Provides
    @FeatureScope
    fun provideViewModelFactory(factory: ViewModelFactory.Factory): ViewModelProvider.Factory {
        return factory.create("testValue123")
    }

}