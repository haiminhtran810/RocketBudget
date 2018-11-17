import money.pro.app.myapplication.screen.MainViewModel
import money.pro.app.myapplication.screen.welcomefragment.WelcomeViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module(override = true) {
    viewModel { WelcomeViewModel() }
    viewModel { MainViewModel() }
}