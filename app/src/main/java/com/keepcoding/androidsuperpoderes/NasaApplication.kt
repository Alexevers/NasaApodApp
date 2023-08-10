package com.keepcoding.androidsuperpoderes

import android.app.Application
import com.keepcoding.androidsuperpoderes.di.dataModule
import com.keepcoding.androidsuperpoderes.di.domainModule
import com.keepcoding.androidsuperpoderes.di.presentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class NasaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@NasaApplication)
            modules(
                presentationModule,
                domainModule,
                dataModule
            )
        }
    }
}
