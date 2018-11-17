import money.pro.app.myapplication.data.Constants
import org.koin.dsl.module.module

val getRepositoryModule = module {
    single { providerDatabaseName() }
}

fun providerDatabaseName(): String = Constants.DATABASE_NAME