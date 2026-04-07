package app.adon.kmplab.presentation.contexts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ThemeVM: ViewModel() {

    var isDark by mutableStateOf(false)
        private set

    fun toggle() {
        isDark = !isDark
    }

}