package app.adon.kmplab.core.di

import org.koin.core.context.startKoin


fun initKoinIos() = startKoin {
    modules(
        commonKoinModule
    )
}