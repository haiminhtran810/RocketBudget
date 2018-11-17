package money.pro.app.myapplication.di

import android.app.Application
import android.content.Context
import android.content.res.Resources
import money.pro.app.myapplication.RocketBudgetApp
import org.koin.dsl.module.module

fun getAppModule() = module(override = true) {
    single { provideApplication(get()) }
    single { provideResource(get()) }
    single { provideContext(get()) }
}

fun provideApplication(mainApplication: RocketBudgetApp): RocketBudgetApp = mainApplication

fun provideResource(application: Application): Resources = application.resources

fun provideContext(application: Application): Context = application