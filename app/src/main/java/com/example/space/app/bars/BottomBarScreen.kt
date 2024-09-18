package com.example.space.app.bars

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import com.example.space.R
import com.example.space.gameViewModel

val listOfScreens: List<BottomBarScreen> by lazy {
    listOf(
        BottomBarScreen.Planet,
        BottomBarScreen.Upgrade,
        BottomBarScreen.Shop,
        BottomBarScreen.Status
    )
}

sealed class BottomBarScreen(
    val route: String,
    @StringRes val bottomAppTitle: Int,
    @ColorRes val color: Int,
    val icon: Any
) {
    data object Planet : BottomBarScreen(
        route = Screens.Planet.name,
        bottomAppTitle = Screens.Planet.bottomAppTitle,
        color = Screens.Planet.color,
        icon = Screens.Planet.icon
    )

    data object Upgrade : BottomBarScreen(
        route = Screens.Upgrade.name,
        bottomAppTitle = Screens.Upgrade.bottomAppTitle,
        color = Screens.Upgrade.color,
        icon = Screens.Upgrade.icon
    )

    data object Shop : BottomBarScreen(
        route = Screens.Shop.name,
        bottomAppTitle = Screens.Shop.bottomAppTitle,
        color = Screens.Shop.color,
        icon = Screens.Shop.icon
    )

    data object Status : BottomBarScreen(
        route = Screens.Status.name,
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
    Shop(
        topAppTitle = gameViewModel.shopAppBar,
        bottomAppTitle = gameViewModel.shopBottomAppBar,
        color = R.color.light_turquoise,
        icon = R.drawable.skin_svgrepo_com
    ),
    Status(
        topAppTitle = gameViewModel.statusAppBar,
        bottomAppTitle = gameViewModel.statusBottomAppBar,
        color = R.color.white,
        icon = Icons.Filled.Star
    )
}