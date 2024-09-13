package com.example.space

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.space.app.bars.BottomBarScreen
import com.example.space.app.bars.BottomNavGraph
import com.example.space.app.bars.Screens
import com.example.space.app.bars.SpaceTopAppBar
import com.example.space.model.GameViewModel

val gameViewModel: GameViewModel = GameViewModel()

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = backStack?.destination
    val conditionForTopAppBar = (currentScreen?.route ?: Screens.Planet.name) != Screens.Planet.name

    Scaffold(
        topBar = {
            SpaceTopAppBar(
                textTopAppBar = if (conditionForTopAppBar) {
                    Screens.valueOf(
                        value = currentScreen?.route ?: Screens.Planet.name
                    ).topAppTitle
                } else {
                    gameViewModel.planetAppBar.intValue
                },
                style = if (conditionForTopAppBar) {
                    MaterialTheme.typography.displaySmall
                } else {
                    MaterialTheme.typography.displayMedium
                },
                color = Screens.valueOf(value = currentScreen?.route ?: Screens.Planet.name).color
            )
        },
        bottomBar = {
            BottomBar(navController = navController, currentScreen = currentScreen)
        }
    ) { innerPadding ->
        @Suppress("UNUSED_VARIABLE") val unnecessaryPadding = innerPadding
        BottomNavGraph(navController = navController, gameViewModel = gameViewModel)
    }
}

@Composable
fun BottomBar(navController: NavHostController, currentScreen: NavDestination?) {
    val screens = listOf(
        BottomBarScreen.Planet,
        BottomBarScreen.Upgrade,
        BottomBarScreen.Status,
    )

    NavigationBar(containerColor = Color.Transparent) {
        screens.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentScreen,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val contentDescription = "Move to ${stringResource(id = screen.bottomAppTitle)}"

    this.NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        alwaysShowLabel = false,
        onClick = { navController.navigate(screen.route) },
        icon = {
            when (screen.icon) {
                is ImageVector -> {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = contentDescription
                    )
                }

                else -> {
                    Icon(
                        painter = painterResource(id = screen.icon as Int),
                        contentDescription = contentDescription
                    )
                }
            }
        },
        colors = NavigationBarItemDefaults.colors(
            unselectedIconColor = Color.White, indicatorColor = colorResource(id = R.color.light_turquoise)
        ),
        label = { Text(text = stringResource(id = screen.bottomAppTitle), color = Color.White) })
}