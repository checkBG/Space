package com.example.space.app.bars

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.space.R
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Straight
import com.exyte.animatednavbar.animation.indendshape.Height

private var selectedIndex = mutableIntStateOf(0)

@Composable
fun BottomBar(navController: NavHostController, currentScreen: NavDestination?, modifier: Modifier) {
    val screens = listOfScreens
    val color by animateColorAsState(
        targetValue = when (currentScreen?.route) {
            BottomBarScreen.Upgrade.route -> colorResource(id = BottomBarScreen.Upgrade.color)
            BottomBarScreen.Status.route -> colorResource(id = BottomBarScreen.Status.color)
            BottomBarScreen.Shop.route -> colorResource(id = BottomBarScreen.Shop.color)
            else -> colorResource(id = BottomBarScreen.Planet.color)
        }, label = "colorState",
        animationSpec = tween(450)
    )

    AnimatedNavigationBar(
        selectedIndex = selectedIndex.intValue,
        barColor = Color.Transparent,
        ballColor = color,
        ballAnimation = Straight(tween(durationMillis = 450, delayMillis = 100)),
        indentAnimation = Height(tween(300)),
        modifier = modifier
    ) {
        screens.forEachIndexed { index, screen ->
            Row {
                AddItem(
                    screen = screen,
                    index = index,
                    currentDestination = currentScreen,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    index: Int,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val contentDescription = "Move to ${stringResource(id = screen.bottomAppTitle)}"
    val isCurrentScreen = currentDestination?.hierarchy?.any { it.route == screen.route }

    this.NavigationBarItem(
        selected = isCurrentScreen == true,
        alwaysShowLabel = false,
        onClick = {
            if (isCurrentScreen == false) {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                }
            }
            selectedIndex.intValue = index
        },
        icon = {
            when (screen.icon) {
                is ImageVector -> {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = contentDescription,
                        modifier = Modifier.size(25.dp)
                    )
                }

                else -> {
                    Icon(
                        painter = painterResource(id = screen.icon as Int),
                        contentDescription = contentDescription,
                        modifier = Modifier.size(25.dp)
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