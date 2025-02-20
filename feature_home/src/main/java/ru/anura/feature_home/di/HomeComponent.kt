package ru.anura.feature_home.di

import dagger.Component
import ru.anura.core.di.CoreComponent
import ru.anura.feature_home.domain.FetchDataUseCase
import ru.anura.feature_home.presentation.HomeViewModel

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeModule::class]
)
interface HomeComponent {
    fun inject(viewModel: HomeViewModel)
    fun fetchDataUseCase(): FetchDataUseCase

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): HomeComponent
    }
}