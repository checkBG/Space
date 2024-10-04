package com.example.space.fundamental

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme
import com.example.space.utils.SpaceScreenSize

@Composable
fun ShopScreen(
    modifier: Modifier = Modifier,
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel
) {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShopScreenPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ShopScreen(
                modifier = Modifier.padding(innerPadding), gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Small
            )
        }
    }
}