package com.example.space.fundamental

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.gameViewModel
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel
) {

}

@Composable
fun StatusScreenPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            StatusScreen(modifier = Modifier.padding(innerPadding), gameViewModel = viewModel())
        }
    }
}