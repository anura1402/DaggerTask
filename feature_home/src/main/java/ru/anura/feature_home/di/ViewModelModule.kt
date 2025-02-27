package ru.anura.feature_home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.anura.feature_home.presentation.HomeViewModel
import ru.anura.feature_home.presentation.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}