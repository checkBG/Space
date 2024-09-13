package com.example.space.fundamental

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.R
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme

@Composable
fun UpgradeScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel
) {
    Box {
        UpgradeBackgroundScreen()

        UpgradeListLazyColumn(gameViewModel = gameViewModel, modifier = modifier)
    }
}

@Composable
fun UpgradeListLazyColumn(
    gameViewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(items = gameViewModel.listOfUpdates) { index, updatableData ->
            updatableData.apply {
                UpgradeSelectionCard(
                    gameViewModel = gameViewModel,
                    index = index
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
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
fun UpgradeSelectionCard(
    gameViewModel: GameViewModel,
    index: Int,
    modifier: Modifier = Modifier
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    // val screenHeight = configuration.screenHeightDp

    Card(
        modifier = modifier
            .width(width = screenWidth.dp)
            .padding(start = 20.dp, end = 20.dp, bottom = 3.dp, top = 3.dp)
    ) {
        gameViewModel.listOfUpdates[index].apply {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    Image(
                        painter = painterResource(id = updatableImage),
                        contentDescription = null,
                        modifier.size(50.dp)
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = stringResource(id = updatableObject),
                        style = TextStyle(fontSize = 35.sp)
                    )
                }

                if (nextLevel != null) {
                    Text(
                        text = stringResource(
                            id = updatableDescription,
                            currentLevel,
                            nextLevel
                        ), style = TextStyle(fontSize = 18.sp)
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp)
                    ) {
                        Text(text = stringResource(id = R.string.upgrade_button), fontSize = 20.sp)
                    }
                } else {
                    Text(
                        text = stringResource(id = R.string.max_level_equals_null),
                        style = TextStyle(fontSize = 18.sp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UpgradeSelectionCardPreview() {
    SpaceTheme {
        UpgradeSelectionCard(
            gameViewModel = GameViewModel(),
            index = 0
        )
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