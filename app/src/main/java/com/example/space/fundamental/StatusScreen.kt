package com.example.space.fundamental

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.R
import com.example.space.gameViewModel
import com.example.space.model.Achievement
import com.example.space.model.AchievementType
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme
import com.example.space.utils.SpaceScreenSize
import com.example.space.utils.getColor
import java.util.Locale

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier,
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel
) {
    val gamePlanetState by gameViewModel.planet.collectAsState()
    val zodiacState by gameViewModel.zodiac.collectAsState()
    val achievements by gameViewModel.listOfAchievements.collectAsState()

    Box {
        StatusScreenBackground()

        ProgressBar(
            currentCoins = gamePlanetState.coins,
            nextCoins = zodiacState.requireCoins,
            zodiacSign = zodiacState.zodiacSign,
            screenSize = screenSize,
            modifier = modifier
        )

        ColumnOfAchievements(
            listOfAchievements = achievements,
            gameViewModel = gameViewModel,
            screenSize = screenSize,
            modifier = modifier
                .padding(top = 140.dp)
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopCenter)
        )
    }
}

@Composable
fun ColumnOfAchievements(
    screenSize: SpaceScreenSize,
    modifier: Modifier = Modifier,
    listOfAchievements: MutableList<Achievement>,
    gameViewModel: GameViewModel
) {
    LazyColumn(modifier = modifier) {
        items(items = listOfAchievements) { achievement ->
            achievement.achievement.apply {
                CardOfAchievement(
                    reward = reward,
                    done = gameViewModel.getCheckedAchievement(achievement = type),
                    type = type,
                    isMaxLevel = achievement.isMaxLevel,
                    requirement = requirement,
                    nameOfAchievement = nameOfAchievement,
                    descriptionOfAchievement = descriptionOfAchievement,
                    isCompleted = achievement.isCompleted,
                    imageOfAchievement = imageOfAchievement,
                    screenSize = screenSize
                )
            }
        }
    }
}

@Composable
fun CardOfAchievement(
    screenSize: SpaceScreenSize,
    modifier: Modifier = Modifier,
    reward: Int,
    isCompleted: Boolean,
    isMaxLevel: Boolean,
    type: AchievementType,
    done: Int,
    requirement: Int,
    @StringRes nameOfAchievement: Int,
    @StringRes descriptionOfAchievement: Int,
    @DrawableRes imageOfAchievement: Int
) {
    val heightOfCard = when (screenSize) {
        SpaceScreenSize.Small -> 105.dp
        SpaceScreenSize.Medium -> 130.dp
        SpaceScreenSize.Large -> 135.dp
    }

    val widthOfCard = when (screenSize) {
        SpaceScreenSize.Small -> 300.dp
        SpaceScreenSize.Medium -> 500.dp
        SpaceScreenSize.Large -> 700.dp
    }

    val turn by animateFloatAsState(
        targetValue = if (isCompleted) 0f else listOf(360f, -360f, 720f, -720f).random(),
        animationSpec = tween(listOf(1000, 900, 800, 700, 600, 500).random()),
        label = "floatStateTurn"
    )

    Column(
        modifier = modifier.padding(end = 5.dp, start = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalDivider(
            thickness = 2.dp,
            color = colorResource(id = R.color.light_turquoise),
            modifier = Modifier.width(500.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
        ) {
            Card {
                Image(
                    painter = painterResource(id = imageOfAchievement),
                    contentDescription = null,
                    modifier = Modifier
                        .size(heightOfCard)
                        .padding(5.dp)
                        .rotate(degrees = turn)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            if (!isCompleted && !isMaxLevel) {
                Card(modifier = Modifier.size(width = widthOfCard, height = heightOfCard)) {
                    Column(modifier = Modifier.padding(3.dp)) {
                        Text(
                            text = stringResource(id = nameOfAchievement),
                            style = MaterialTheme.typography.displaySmall
                        )

                        Text(
                            text = stringResource(
                                id = R.string.reward,
                                String.format(Locale.getDefault(), "%,d", reward)
                            )
                        )

                        Text(
                            text = stringResource(
                                id = descriptionOfAchievement,
                                String.format(Locale.getDefault(), "%,d", done)
                            )
                        )

                        Text(
                            text = stringResource(
                                id = R.string.requirement,
                                String.format(Locale.getDefault(), "%,d", requirement)
                            )
                        )
                    }
                }
            } else if (isCompleted && !isMaxLevel) {
                Card(
                    onClick = { gameViewModel.gotReward(achievement = type) },
                    border = BorderStroke(
                        width = 3.dp, brush = Brush.radialGradient(
                            colors = listOf(
                                colorResource(id = R.color.sun),
                                colorResource(id = R.color.star),
                                colorResource(id = R.color.light_turquoise)
                            )
                        )
                    ),
                    modifier = Modifier.size(width = widthOfCard, height = heightOfCard)
                ) {
                    Text(
                        text = stringResource(
                            id = R.string.get_reward,
                            String.format(Locale.getDefault(), "%,d", reward)
                        ),
                        style = MaterialTheme.typography.displaySmall,
                        modifier = Modifier
                            .padding(3.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                    )
                }
            } else {
                Card(modifier = Modifier.size(width = widthOfCard, height = heightOfCard)) {
                    Text(
                        text = stringResource(id = R.string.is_max_level),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(5.dp)
                            .align(alignment = Alignment.Start)
                    )
                }
            }
        }

        /* TODO: Have to implement Progress bar */
        Spacer(modifier = Modifier.height(8.dp))

        if (!isMaxLevel) {
            ProgressBarForAchievement(
                currentCoins = done,
                requirement = requirement,
                screenSize = screenSize,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        HorizontalDivider(
            thickness = 2.dp,
            color = colorResource(id = R.color.light_turquoise),
            modifier = Modifier.width(500.dp)
        )
    }
}

@Composable
fun StatusScreenBackground(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.blackspace),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun ProgressBarForAchievement(
    screenSize: SpaceScreenSize,
    modifier: Modifier = Modifier,
    currentCoins: Int,
    requirement: Int
) {
    val heightOfProgressBar = when (screenSize) {
        SpaceScreenSize.Small -> 7.dp
        SpaceScreenSize.Medium -> 9.dp
        SpaceScreenSize.Large -> 11.dp
    }
    val widthOfCanvas = when (screenSize) {
        SpaceScreenSize.Small -> 250.dp
        SpaceScreenSize.Medium -> 400.dp
        SpaceScreenSize.Large -> 600.dp
    }

    val percentage by animateFloatAsState(
        targetValue = if (currentCoins <= requirement) {
            currentCoins.toFloat() / requirement.toFloat()
        } else 1f,
        animationSpec = tween(250),
        label = "floatStateProgressBar"
    )

    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier.size(
                width = widthOfCanvas, height = heightOfProgressBar
            )
        ) {
            drawRoundRect( // is the background of the rect if the progress less than 100%
                color = Color(0xFFFFFFFF),
                size = Size(size.width, size.height - 1f),
                cornerRadius = CornerRadius(50f)
            )

            drawRoundRect( // is the second rect of the progress. Has been created emphasizing the main rect
                color = Color(0xFF6600FF),
                topLeft = Offset(-0.5f, -0.5f),
                size = Size(size.width * percentage, size.height),
                cornerRadius = CornerRadius(50f)
            )

            drawRoundRect( // is the main rect of the progress
                color = Color(0xFF4F800F),
                size = Size(size.width * percentage, size.height),
                cornerRadius = CornerRadius(50f)
            )
        }
    }
}

@Composable
fun ProgressBar(
    screenSize: SpaceScreenSize,
    modifier: Modifier = Modifier,
    currentCoins: Int,
    nextCoins: Int,
    @StringRes zodiacSign: Int
) {
    val intentForWidthArrow = 32f
    val intentForHeightArrow = 50f
    val percentage by animateFloatAsState(
        targetValue = currentCoins.toFloat() / nextCoins.toFloat(),
        animationSpec = tween(300),
        label = "floatState"
    )
    val colorOfArrow by animateColorAsState(
        targetValue = percentage.getColor(), label = "colorState"
    )

    Box(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = zodiacSign),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
            )

            Canvas(
                modifier = Modifier.size(
                    width = when (screenSize) {
                        SpaceScreenSize.Small -> 280.dp
                        SpaceScreenSize.Medium -> 400.dp
                        SpaceScreenSize.Large -> 450.dp
                    }, height = 7.5.dp
                )
            ) {
                drawRoundRect( // is the background of the rect if the progress less than 100%
                    color = Color.LightGray,
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(50f)
                )

                drawRoundRect( // is the second rect of the progress. Has been created emphasizing the main rect
                    brush = Brush.linearGradient(listOf(Color(0xFF6600FF), Color(0xFF9400D3))),
                    topLeft = Offset(-0.5f, -0.5f),
                    size = Size((size.width + 4.5f) * percentage, size.height + 3.5f),
                    cornerRadius = CornerRadius(50f)
                )

                drawRoundRect( // is the main rect of the progress
                    brush = Brush.linearGradient(listOf(Color(0xFFECE086), Color(0xFFAA7711))),
                    size = Size(size.width * percentage, size.height),
                    cornerRadius = CornerRadius(50f)
                )


                drawPath( // is the second arrow emphasizing a line of the main arrow
                    path = Path().apply {
                        moveTo(
                            size.width * percentage - intentForWidthArrow,
                            size.height / 2f - intentForHeightArrow
                        ) // start position
                        cubicTo(
                            size.width * percentage - 4f - intentForWidthArrow,
                            size.height / 2f - intentForHeightArrow, // draw a line a little lower in order to set the thickness of the arrow on the top
                            size.width * percentage + 50f - intentForWidthArrow,
                            size.height / 2f + 42f - intentForHeightArrow, // draw a line to the center. Change the first "x" in order to set the thickness of the arrow on the center on the left side
                            size.width * percentage - intentForWidthArrow,
                            size.height / 2f + 100f - intentForHeightArrow // draw a line to back to the beginning but quite lower
                        )
                        lineTo(
                            size.width * percentage - 3f - intentForWidthArrow,
                            size.height / 2f + 105f - intentForHeightArrow
                        ) // draw a line a little lower in order to set the thickness of the arrow on the bottom
                        lineTo(
                            size.width * percentage + 35f - intentForWidthArrow,
                            size.height / 2f + 50f - intentForHeightArrow
                        ) // draw a line to back to the center. Change the first "x" in order to set the thickness of the arrow on the center on the right side
                        close() // we've created a line
                    },
                    brush = Brush.radialGradient(colors = listOf(Color.Green, Color.Yellow)),
                    style = Stroke(width = 3.5f)
                )

                drawPath( // is the main arrow
                    path = Path().apply {
                        moveTo(
                            size.width * percentage - intentForWidthArrow,
                            size.height / 2f - intentForHeightArrow
                        ) // start position
                        cubicTo(
                            size.width * percentage - 4f - intentForWidthArrow,
                            size.height / 2f - intentForHeightArrow, // draw a line a little lower in order to set the thickness of the arrow on the top
                            size.width * percentage + 50f - intentForWidthArrow,
                            size.height / 2f + 42f - intentForHeightArrow, // draw a line to the center. Change the first "x" in order to set the thickness of the arrow on the center on the left side
                            size.width * percentage - intentForWidthArrow,
                            size.height / 2f + 100f - intentForHeightArrow // draw a line to back to the beginning but quite lower
                        )
                        lineTo(
                            size.width * percentage - 3f - intentForWidthArrow,
                            size.height / 2f + 105f - intentForHeightArrow
                        ) // draw a line a little lower in order to set the thickness of the arrow on the bottom
                        lineTo(
                            size.width * percentage + 35f - intentForWidthArrow,
                            size.height / 2f + 50f - intentForHeightArrow
                        ) // draw a line to back to the center. Change the first "x" in order to set the thickness of the arrow on the center on the right side
                        close() // we've created a line
                    },
                    color = colorOfArrow,
                    style = Stroke(width = 2f)
                )
            }

            Text(
                text = "$currentCoins |$nextCoins",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProgressBarOfAchievementsPreview() {
    SpaceTheme(darkTheme = true) {
        ProgressBarForAchievement(
            currentCoins = 100,
            requirement = 1000,
            modifier = Modifier.fillMaxSize(),
            screenSize = SpaceScreenSize.Small
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawArrowPreview() {
    SpaceTheme(darkTheme = true) {
        ProgressBar(
            currentCoins = 40,
            nextCoins = 100,
            zodiacSign = R.string.zodiac_sign_aries,
            screenSize = SpaceScreenSize.Small
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StatusScreenCompactPreview() {
    SpaceTheme {
        StatusScreen(
            modifier = Modifier, gameViewModel = viewModel(),
            screenSize = SpaceScreenSize.Small
        )
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun StatusScreenMediumPreview() {
    SpaceTheme {
        StatusScreen(
            modifier = Modifier, gameViewModel = viewModel(),
            screenSize = SpaceScreenSize.Medium
        )
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun StatusScreenLargePreview() {
    SpaceTheme {
        StatusScreen(
            modifier = Modifier, gameViewModel = viewModel(),
            screenSize = SpaceScreenSize.Large
        )
    }
}