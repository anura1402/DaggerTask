package ru.anura.feature_home.di

import dagger.Component
import ru.anura.core.di.CoreComponent
import ru.anura.feature_home.presentation.HomeFragment
import ru.anura.feature_home.presentation.ViewModelFactory

@FeatureScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [HomeModule::class, ViewModelModule::class]
)
interface HomeComponent {
    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): HomeComponent
    }
}