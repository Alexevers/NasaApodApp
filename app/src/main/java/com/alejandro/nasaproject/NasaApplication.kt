package com.alejandro.nasaproject

import android.app.Application
import com.alejandro.nasaproject.di.dataModule
import com.alejandro.nasaproject.di.domainModule
import com.alejandro.nasaproject.di.presentationModule
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
