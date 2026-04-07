package app.adon.kmplab

import android.app.Application
import app.adon.kmplab.core.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainAndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MainAndroidApplication)
        }
    }

}