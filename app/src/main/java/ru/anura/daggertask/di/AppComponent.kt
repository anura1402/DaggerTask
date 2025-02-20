package ru.anura.daggertask.di

import dagger.Component
import ru.anura.core.di.NetworkModule
import ru.anura.daggertask.MyApp
import ru.anura.feature_home.di.HomeModule


@Component(
    modules = [
        NetworkModule::class,  // Из core
        HomeModule::class      // Из feature_home
    ]
)
interface AppComponent {
    fun inject(app: MyApp)
}