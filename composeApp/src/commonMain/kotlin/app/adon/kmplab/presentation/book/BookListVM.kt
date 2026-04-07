package app.adon.kmplab.presentation.book

import androidx.lifecycle.ViewModel
import app.adon.kmplab.data.fakers.BookFaker

class BookListVM: ViewModel() {

    val books = BookFaker.generate(10)

}