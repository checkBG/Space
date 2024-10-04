package com.example.space.fundamental

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
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
import com.example.space.utils.SpaceScreenSize

@Composable
fun UpgradeScreen(
    modifier: Modifier = Modifier,
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel
) {
    Box {
        UpgradeBackgroundScreen()

        UpgradeListLazyColumn(
            gameViewModel = gameViewModel,
            modifier = modifier,
            screenSize = screenSize
        )
    }
}

@Composable
fun UpgradeListLazyColumn(
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    val listOfUpdatesUi by gameViewModel.listOfUpdates.collectAsState()

    LazyColumn(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        itemsIndexed(items = listOfUpdatesUi) { index, updatableData ->
            updatableData.apply {
                UpgradeSelectionCard(
                    gameViewModel = gameViewModel,
                    index = index,
                    screenSize = screenSize
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun UpgradeBackgroundScreen() {
    Image(
        painter = painterResource(id = R.drawable.spacebackgroundforupgradescreen5120x2880),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun UpgradeSelectionCard(
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel,
    index: Int,
    modifier: Modifier = Modifier
) {
    val listOfUpdatesUi by gameViewModel.listOfUpdates.collectAsState()
    val gamePlanetState by gameViewModel.planet.collectAsState()

    val widthOfLazyColumn = when (screenSize) {
        SpaceScreenSize.Small -> 400.dp
        SpaceScreenSize.Medium -> 550.dp
        SpaceScreenSize.Large -> 700.dp
    }

    Card(
        modifier = modifier
            .width(width = widthOfLazyColumn)
            .padding(start = 20.dp, end = 20.dp, bottom = 3.dp, top = 3.dp),

    ) {
        listOfUpdatesUi[index].apply {
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
                        text = stringResource(id = updatableDescription),
                        style = TextStyle(fontSize = 18.sp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Column {
                        Text(
                            text = stringResource(
                                id = R.string.levels,
                                currentLevel,
                                nextLevel
                            ),
                            style = TextStyle(fontSize = 18.sp)
                        )

                        Spacer(modifier = Modifier.weight(1f, fill = false))

                        Text(
                            text = stringResource(
                                id = R.string.require,
                                gamePlanetState.coins,
                                requiredToUp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { onClick(index, requiredToUp) },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.turquoise)),
                        enabled = (gamePlanetState.coins - requiredToUp >= 0),
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
            index = 0,
            screenSize = SpaceScreenSize.Small
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UpgradeScreenCompactPreview() {
    SpaceTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UpgradeScreen(
                modifier = Modifier, gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Small
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun UpgradeScreenMediumPreview() {
    SpaceTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UpgradeScreen(
                modifier = Modifier, gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Medium
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun UpgradeScreenLargePreview() {
    SpaceTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            UpgradeScreen(
                modifier = Modifier, gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Large
            )
        }
    }
}