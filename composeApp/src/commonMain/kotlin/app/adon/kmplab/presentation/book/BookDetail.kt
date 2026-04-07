package app.adon.kmplab.presentation.book

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel


@Preview(showBackground = true)
@Composable
fun BookDetail(
    sharedBookVM: SharedBookVM = koinViewModel()
) {

    val selected by sharedBookVM.selected

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = selected
                ?.let { "id: ${it.id} | name: ${it.name}" }
                ?: "- não encontrado -"
        )
    }
}