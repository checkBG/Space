package com.example.space.fundamental

import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.space.model.GameViewModel

private val GameViewModel = GameViewModel()

sealed class BottomBarScreen(
    val route: String,
    val title: Int,
    val icon: ImageVector
) {
    object Planet : BottomBarScreen(
        route = Screens.Planet.name,
        title = Screens.Planet.title,
        icon = Screens.Planet.icon
    )

    object Upgrade : BottomBarScreen(
        route = Screens.Upgrade.name,
        title = Screens.Upgrade.title,
        icon = Screens.Upgrade.icon
    )

    object Status : BottomBarScreen(
        route = Screens.Status.name,
        title = Screens.Status.title,
        icon = Screens.Status.icon
    )
}

enum class Screens(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Planet(title = GameViewModel.upgradeAppBar, icon = Icons.Filled.Home),
    Upgrade(title = GameViewModel.upgradeAppBar, icon = Icons.Filled.KeyboardArrowUp),
    Status(title = GameViewModel.statusAppBar, icon = Icons.Filled.Star)
}