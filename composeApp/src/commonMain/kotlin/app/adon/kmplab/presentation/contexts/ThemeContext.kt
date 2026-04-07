package app.adon.kmplab.presentation.contexts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import org.koin.compose.viewmodel.koinViewModel

@Immutable
data class ThemeColors(
    val primary: Color,
    val background: Color,
)
val ThemeColorsLight = ThemeColors(
    primary = Color(0xFF3B3B3B),
    background = Color.White
)
val ThemeColorsDark = ThemeColors(
    primary = Color.White,
    background = Color(0xFF3B3B3B)
)
val ThemeLocal = staticCompositionLocalOf<ThemeColors> {
    error("Implemente ThemeColors")
}

// ====
interface ThemeController {
    fun toggle()
}
val ThemeControllerLocal = staticCompositionLocalOf<ThemeController> {
    error("Implemente ThemeController")
}

@Composable
fun ThemeView(
    vm: ThemeVM = koinViewModel(),
    content: @Composable () -> Unit
) {

    val colors = if (vm.isDark) ThemeColorsDark else ThemeColorsLight

    //
    val controller = remember(vm) {
        object : ThemeController {
            override fun toggle() {
                vm.toggle()
            }
        }
    }


    //
    CompositionLocalProvider(
        ThemeLocal provides colors,
        ThemeControllerLocal provides controller
    ) {
        ThemeSystemAppearance(vm.isDark)
        content()
    }

}

object Theme {

    val colors: ThemeColors
        @Composable
        @ReadOnlyComposable
        get() = ThemeLocal.current

    val controller: ThemeController
        @Composable
        @ReadOnlyComposable
        get() = ThemeControllerLocal.current
}


//
//@Composable
//fun ThemeLocalContext(darkTheme: Boolean = false, content: @Composable () -> Unit) {
//    val colors = if (darkTheme)
//        ThemeColors(Color.White, Color.Black, true)
//    else
//        ThemeColors(Color.Black, Color.White, false)
//
//    CompositionLocalProvider(ThemeLocal provides colors) {
//        content()
//    }
//}