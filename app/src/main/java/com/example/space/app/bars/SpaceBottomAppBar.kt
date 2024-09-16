package com.example.space.app.bars

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.space.R


@Composable
fun BottomBar(navController: NavHostController, currentScreen: NavDestination?) {
    val screens = listOfScreens

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
        onClick = {
            if (currentDestination?.hierarchy?.any { it.route == screen.route } == false) {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }
        },
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
            unselectedIconColor = Color.White,
            indicatorColor = colorResource(id = R.color.light_turquoise)
        ),
        label = { Text(text = stringResource(id = screen.bottomAppTitle), color = Color.White) })
}