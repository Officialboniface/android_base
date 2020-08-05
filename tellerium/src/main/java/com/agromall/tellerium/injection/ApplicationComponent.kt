package com.agromall.tellerium.injection

import android.app.Application
import com.agromall.tellerium.App
import com.agromall.tellerium.injection.module.ApplicationModule
import com.agromall.tellerium.injection.module.CacheModule
import com.agromall.tellerium.injection.module.DataModule
import com.agromall.tellerium.injection.module.PresentationModule
import com.agromall.tellerium.injection.module.RemoteModule
import com.agromall.tellerium.injection.module.UiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        UiModule::class,
        PresentationModule::class,
        DataModule::class,
        CacheModule::class,
        RemoteModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun create(app: Application): Builder

        fun build(): ApplicationComponent
    }
}