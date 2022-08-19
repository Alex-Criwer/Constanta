package com.example.constanta.app

import android.app.Application
import com.example.constanta.di.dataModule
import com.example.constanta.di.domainModule
import com.example.constanta.di.presentationModule
import org.koin.core.context.startKoin
import timber.log.Timber

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin {
            modules(listOf(dataModule, domainModule, presentationModule))
        }
    }
}