package com.example.space

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.space.app.bars.BottomBar
import com.example.space.app.bars.BottomNavGraph
import com.example.space.app.bars.Screens
import com.example.space.app.bars.SpaceTopAppBar
import com.example.space.model.GameViewModel
import com.example.space.utils.SpaceScreenSize

val gameViewModel: GameViewModel = GameViewModel()

@Composable
fun MainScreen(windowSize: WindowWidthSizeClass, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentScreen = backStack?.destination
    val conditionForTopAppBar = (currentScreen?.route ?: Screens.Planet.name) != Screens.Planet.name
    val screenSize: SpaceScreenSize

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            screenSize = SpaceScreenSize.Small
        }

        WindowWidthSizeClass.Medium -> {
            screenSize = SpaceScreenSize.Medium
        }

        WindowWidthSizeClass.Expanded -> {
            screenSize = SpaceScreenSize.Large
        }

        else -> {
            screenSize = SpaceScreenSize.Small
        }
    }

    Scaffold(
        topBar = {
            SpaceTopAppBar(
                textTopAppBar = if (conditionForTopAppBar) {
                    Screens.valueOf(
                        value = currentScreen?.route ?: Screens.Planet.name
                    ).topAppTitle
                } else {
                    gameViewModel.planetAppBar.intValue
                },
                style = if (conditionForTopAppBar) {
                    MaterialTheme.typography.displaySmall
                } else {
                    MaterialTheme.typography.displayMedium
                },
                color = Screens.valueOf(value = currentScreen?.route ?: Screens.Planet.name).color,
                modifier = modifier
            )
        },
        bottomBar = {
            BottomBar(navController = navController, currentScreen = currentScreen, modifier = modifier)
        }
    ) { innerPadding ->
        BottomNavGraph(
            screenSize = screenSize,
            navController = navController,
            gameViewModel = gameViewModel,
            modifier = modifier.padding(innerPadding)
        )
    }
}
