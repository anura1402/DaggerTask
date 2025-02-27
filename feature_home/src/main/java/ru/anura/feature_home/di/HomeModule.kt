package ru.anura.feature_home.di

import dagger.Module
import dagger.Provides
import ru.anura.core.domain.Repository
import ru.anura.feature_home.domain.FetchDataUseCase
import ru.anura.feature_home.presentation.HomeViewModel
import ru.anura.feature_home.presentation.ViewModelFactory

@Module
class HomeModule {

    @Provides
    @FeatureScope
    fun provideRepository(repositoryImpl: ru.anura.core.repositoryImpl.RepositoryImpl): Repository = repositoryImpl

    @Provides
    @FeatureScope
    fun provideFetchDataUseCase(repository: Repository): FetchDataUseCase {
        return FetchDataUseCase(repository)
    }

}