package com.example.space.fundamental

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.R
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme

@Composable
fun UpgradeScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel
) {
    Box(modifier = modifier) {
        UpgradeBackgroundScreen()

        LazyColumn {
//            items(items = )
        }
    }
}

@Composable
fun UpgradeBackgroundScreen() {
    Image(
        painter = painterResource(id = R.drawable.backgroundforupdatescreen),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun UpgradeSelectionCard(modifier: Modifier = Modifier) {
    Card(modifier = modifier
        .padding(20.dp)
        .size(200.dp)) {

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UpgradeScreenPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            UpgradeScreen(modifier = Modifier.padding(innerPadding), gameViewModel = viewModel())
        }
    }
}