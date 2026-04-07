package app.adon.kmplab.core.di

import app.adon.kmplab.presentation.book.BookListVM
import app.adon.kmplab.presentation.book.SharedBookVM
import app.adon.kmplab.presentation.contexts.ThemeVM
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


//
val commonKoinModule = module {

    viewModelOf(::SharedBookVM)
    viewModelOf(::BookListVM)
    viewModelOf(::ThemeVM)

}

//
fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        commonKoinModule
    )
}