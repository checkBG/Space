package com.example.space.app.bars

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.space.fundamental.PlanetScreen
import com.example.space.fundamental.ShopScreen
import com.example.space.fundamental.StatusScreen
import com.example.space.fundamental.UpgradeScreen
import com.example.space.model.GameViewModel
import com.example.space.utils.SpaceScreenSize

@Composable
fun BottomNavGraph(
    screenSize: SpaceScreenSize,
    navController: NavHostController,
    gameViewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Planet.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = BottomBarScreen.Planet.route) {
            PlanetScreen(gameViewModel = gameViewModel, screenSize = screenSize)
        }

        composable(route = BottomBarScreen.Upgrade.route) {
            UpgradeScreen(gameViewModel = gameViewModel, modifier = modifier, screenSize = screenSize)
        }

        composable(route = BottomBarScreen.Shop.route) {
            ShopScreen(gameViewModel = gameViewModel, screenSize = screenSize)
        }

        composable(route = BottomBarScreen.Status.route) {
            StatusScreen(gameViewModel = gameViewModel, modifier = modifier, screenSize = screenSize)
        }
    }
}