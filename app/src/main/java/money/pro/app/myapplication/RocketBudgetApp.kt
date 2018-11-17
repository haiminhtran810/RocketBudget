package money.pro.app.myapplication

import android.app.Application
import money.pro.app.myapplication.di.getApiModule
import money.pro.app.myapplication.di.getAppModule
import org.koin.android.ext.android.startKoin
import viewModelModule

class RocketBudgetApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
            getApiModule(),
            getAppModule(),
            viewModelModule
        ))
    }
}