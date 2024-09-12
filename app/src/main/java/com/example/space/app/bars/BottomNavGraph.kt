package com.example.space.app.bars

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.space.fundamental.PlanetScreen
import com.example.space.fundamental.StatusScreen
import com.example.space.fundamental.UpgradeScreen
import com.example.space.model.GameViewModel

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    gameViewModel: GameViewModel
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Planet.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = BottomBarScreen.Planet.route) {
            PlanetScreen(gameViewModel = gameViewModel)
        }

        composable(route = BottomBarScreen.Upgrade.route) {
            UpgradeScreen(gameViewModel = gameViewModel)
        }

        composable(route = BottomBarScreen.Status.route) {
            StatusScreen(gameViewModel = gameViewModel)
        }
    }
}