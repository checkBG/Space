package com.example.space.app.bars

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.space.R
import com.example.space.gameViewModel

sealed class BottomBarScreen(
    val route: String,
    @StringRes val topAppTitle: Int,
    @StringRes val bottomAppTitle: Int,
    @ColorRes val color: Int,
    val icon: Any
) {
    object Planet : BottomBarScreen(
        route = Screens.Planet.name,
        topAppTitle = Screens.Planet.topAppTitle,
        bottomAppTitle = Screens.Planet.bottomAppTitle,
        color = Screens.Planet.color,
        icon = Screens.Planet.icon
    )

    object Upgrade : BottomBarScreen(
        route = Screens.Upgrade.name,
        topAppTitle = Screens.Upgrade.topAppTitle,
        bottomAppTitle = Screens.Upgrade.bottomAppTitle,
        color = Screens.Upgrade.color,
        icon = Screens.Upgrade.icon
    )

    object Status : BottomBarScreen(
        route = Screens.Status.name,
        topAppTitle = Screens.Status.topAppTitle,
        bottomAppTitle = Screens.Status.bottomAppTitle,
        color = Screens.Status.color,
        icon = Screens.Status.icon
    )
}

enum class Screens(
    @StringRes val topAppTitle: Int,
    @StringRes val bottomAppTitle: Int,
    @ColorRes val color: Int,
    val icon: Any
) {
    Planet(
        topAppTitle = R.string.app_name, /* this parameter definitely should be initialized in MainScreen
because it always changes if count of coins become define amount initialized in viewModel */
        bottomAppTitle = gameViewModel.planetBottomAppBar,
        color = R.color.persian_blue,
        icon = Icons.Filled.Home
    ),
    Upgrade(
        topAppTitle = gameViewModel.upgradeAppBar,
        bottomAppTitle = gameViewModel.upgradeBottomAppBar,
        color = R.color.turquoise,
        icon = R.drawable.arrows_up
    ),
    Status(
        topAppTitle = gameViewModel.statusAppBar,
        bottomAppTitle = gameViewModel.statusBottomAppBar,
        color = R.color.black,
        icon = Icons.Filled.Star
    )
}