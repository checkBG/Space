package com.example.space

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.space.fundamental.Screens
import com.example.space.fundamental.SpaceTopAppBar
import com.example.space.model.GameViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val gameViewModel: GameViewModel = viewModel()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = navController.currentDestination?.route ?: Screens.Planet.name

    Scaffold(
        topBar = {
            SpaceTopAppBar(textTopAppBar = Screens.valueOf(value = currentScreen).title)
        },
        bottomBar = {

        }
    ) { innerPadding ->
        val unnecessaryPadding = innerPadding
        BottomNavGraph(navController = navController, gameViewModel = gameViewModel)
    }
}