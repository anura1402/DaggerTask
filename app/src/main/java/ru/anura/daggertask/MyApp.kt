package ru.anura.daggertask

import android.app.Application
import ru.anura.core.di.CoreComponent
import ru.anura.core.di.DaggerCoreComponent
import ru.anura.daggertask.di.AppComponent
import ru.anura.daggertask.di.DaggerAppComponent
import ru.anura.feature_home.di.HomeComponentProvider
import ru.anura.feature_home.di.DaggerHomeComponent
import ru.anura.feature_home.di.HomeComponent

class MyApp : Application(), HomeComponentProvider {
    lateinit var appComponent: AppComponent
    lateinit var coreComponent: CoreComponent
    override fun getHomeComponent(): HomeComponent {
        return DaggerHomeComponent.factory().create(coreComponent)
    }
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().build()
        coreComponent = DaggerCoreComponent.factory().create()
    }
}