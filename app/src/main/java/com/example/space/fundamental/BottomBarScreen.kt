package com.example.space.fundamental

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.space.gameViewModel
import com.example.space.model.GameViewModel

//private val GameViewModel = GameViewModel()

sealed class BottomBarScreen(
    val route: String,
    @StringRes val topAppTitle: Int,
    @StringRes val bottomAppTitle: Int,
    val icon: ImageVector
) {
    object Planet : BottomBarScreen(
        route = Screens.Planet.name,
        topAppTitle = Screens.Planet.topAppTitle,
        bottomAppTitle = Screens.Planet.bottomAppTitle,
        icon = Screens.Planet.icon
    )

    object Upgrade : BottomBarScreen(
        route = Screens.Upgrade.name,
        topAppTitle = Screens.Upgrade.topAppTitle,
        bottomAppTitle = Screens.Upgrade.bottomAppTitle,
        icon = Screens.Upgrade.icon
    )

    object Status : BottomBarScreen(
        route = Screens.Status.name,
        topAppTitle = Screens.Status.topAppTitle,
        bottomAppTitle = Screens.Status.bottomAppTitle,
        icon = Screens.Status.icon
    )
}

enum class Screens(
    @StringRes val topAppTitle: Int,
    @StringRes val bottomAppTitle: Int,
    val icon: ImageVector
) {
    Planet(
        topAppTitle = gameViewModel.planetAppBar.intValue,
        bottomAppTitle = gameViewModel.planetBottomAppBar,
        icon = Icons.Filled.Home
    ),
    Upgrade(
        topAppTitle = gameViewModel.upgradeAppBar,
        bottomAppTitle = gameViewModel.upgradeBottomAppBar,
        icon = Icons.Filled.KeyboardArrowUp
    ),
    Status(
        topAppTitle = gameViewModel.statusAppBar,
        bottomAppTitle = gameViewModel.statusBottomAppBar,
        icon = Icons.Filled.Star
    )
}