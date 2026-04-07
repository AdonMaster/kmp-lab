@file:OptIn(ExperimentalMaterial3Api::class)

package app.adon.kmplab.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import app.adon.kmplab.core.extensions.vmFrom
import app.adon.kmplab.presentation.book.BookDetail
import app.adon.kmplab.presentation.book.BookList
import app.adon.kmplab.presentation.book.SharedBookVM
import compose.icons.FeatherIcons
import compose.icons.feathericons.ChevronLeft
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val navEntry by navController.currentBackStackEntryAsState()
    val hierarchyRoutes = navEntry?.destination
        ?.hierarchy
        ?.toList()
        ?.mapNotNull { it.route }
        ?: emptyList()

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Adon") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue.copy(alpha = 0.8f),
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    if (hierarchyRoutes.isNotEmpty()) {
                        IconButton(onClick = {
                            if (navController.previousBackStackEntry != null) {
                                navController.popBackStack()
                            }
                        }) {
                            Icon(
                                imageVector = FeatherIcons.ChevronLeft, contentDescription = "back",
                                tint = Color.White.copy(0.5f)
                            )
                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomBar(hierarchyRoutes) { route ->
                navController.navigate(route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = false
                    }
                    launchSingleTop = true
                    restoreState = false
                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            hierarchyRoutes.forEach {
                Text("route: $it", modifier = Modifier)
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 20.dp))

            NavHost(
                navController = navController,
                startDestination = "/home",
                modifier = Modifier.weight(1f)
            ) {
                composable("/home") {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("home")
                    }
                }
                navigation(route = "/books", startDestination = "/book/list") {
                    composable(route = "/book/list") {
                        BookList(sharedBookVM = navController.vmFrom("/books")) { route ->
                            navController.navigate(route)
                        }
                    }

                    composable(route = "/book/detail") {
                        BookDetail(sharedBookVM = navController.vmFrom("/books"))
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    MainScreen()
}