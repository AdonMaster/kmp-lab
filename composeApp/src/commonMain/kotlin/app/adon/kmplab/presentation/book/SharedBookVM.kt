package app.adon.kmplab.presentation.book

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import app.adon.kmplab.domain.entity.Book

class SharedBookVM: ViewModel() {

    val selected = mutableStateOf<Book?>(null)

}