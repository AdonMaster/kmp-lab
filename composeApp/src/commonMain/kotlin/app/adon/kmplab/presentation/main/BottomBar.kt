package app.adon.kmplab.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import compose.icons.FeatherIcons
import compose.icons.feathericons.Book
import compose.icons.feathericons.Home
import compose.icons.feathericons.Plus

@Composable
fun BottomBar(routeStack: List<String>, onNavigate: (String) -> Unit)
{
    val btns: List<Pair<String, Color>> = listOf(
        "/home" to Color.Unspecified,
        "/books" to Color.Unspecified,
    ).map { b ->
        b.copy(
            second = if (routeStack.contains(b.first))
                Color.White
            else
                Color.Unspecified
        )
    }

    BottomAppBar {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onNavigate(btns[0].first) },
                modifier = Modifier.size(50.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = btns[0].second,
                )
            ) {
                Icon(FeatherIcons.Home, "home")
            }

            FloatingActionButton(
                onClick = { /* ação */ },
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor
            ) {
                Icon(FeatherIcons.Plus, "add")
            }

            IconButton(
                onClick = { onNavigate(btns[1].first) },
                modifier = Modifier.size(50.dp),
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = btns[1].second
                )
            ) {
                Icon(FeatherIcons.Book, "books")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarPreview() {
    BottomBar(listOf("/home")) {

    }
}