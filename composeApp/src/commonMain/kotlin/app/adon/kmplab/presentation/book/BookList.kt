package app.adon.kmplab.presentation.book

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun BookList(
    sharedBookVM: SharedBookVM = koinViewModel(),
    vm: BookListVM = koinViewModel(),
    onBook: (String) -> Unit
) {

    val list = vm.books
    var selected by sharedBookVM.selected

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("books index")
            list.forEach { book ->
                Button({
                    selected = book
                    onBook("/book/detail")
                }) {
                    Text("book detail ${book.name} ->")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BookListPreview() {
    MaterialTheme {
        BookList {  }
    }
}