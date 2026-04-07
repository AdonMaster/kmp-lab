package app.adon.kmplab.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import org.koin.compose.viewmodel.koinViewModel

@Composable
inline fun <reified T: ViewModel> NavHostController.vmFrom(route: String): T {
    val routeEntry = remember(this, route) { getBackStackEntry(route) }
    return koinViewModel<T>(viewModelStoreOwner = routeEntry)
}