package com.example.coursesapp

import android.app.Application
import com.example.coursesapp.di.appModule
import com.example.coursesapp.di.dataModule
import com.example.coursesapp.di.databaseModule
import com.example.coursesapp.di.domainModule
import com.example.coursesapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule, networkModule, databaseModule))
        }
    }

}