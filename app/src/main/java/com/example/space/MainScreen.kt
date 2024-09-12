package com.example.space

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.space.fundamental.BottomBarScreen
import com.example.space.fundamental.Screens
import com.example.space.fundamental.SpaceTopAppBar
import com.example.space.model.GameViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    /* TODO: WARNING IT'LL BE ABLE TO CALL ANY PROBLEMS!!
    TODO: If any: made this property as a public to change state in another Classes */
    val gameViewModel: GameViewModel = viewModel()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = backStack?.destination

    Scaffold(
        topBar = {
            SpaceTopAppBar(
                textTopAppBar = Screens.valueOf(
                    value = currentScreen?.route ?: Screens.Planet.name
                ).topAppTitle
            )
        },
        bottomBar = {
            BottomBar(navController = navController, currentScreen = currentScreen)
        }
    ) { innerPadding ->
        val unnecessaryPadding = innerPadding
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

    NavigationBar {
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
    this.NavigationBarItem(
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = { navController.navigate(screen.route) },
        icon = {
            Icon(
                screen.icon,
                contentDescription = "Move to ${stringResource(id = screen.bottomAppTitle)}"
            )
        },
        label = { Text(text = stringResource(id = screen.bottomAppTitle)) })
}