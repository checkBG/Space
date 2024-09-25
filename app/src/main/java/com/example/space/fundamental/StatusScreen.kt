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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
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
import com.example.space.utils.getColor
import java.util.Locale

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier,
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
            modifier = modifier
        )

        ColumnOfAchievements(
            listOfAchievements = achievements,
            gameViewModel = gameViewModel,
            modifier = modifier
                .padding(top = 140.dp)
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopCenter)
        )
    }
}

@Composable
fun ColumnOfAchievements(
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
                    requirement = requirement,
                    nameOfAchievement = nameOfAchievement,
                    descriptionOfAchievement = descriptionOfAchievement,
                    isCompleted = achievement.isCompleted,
                    imageOfAchievement = imageOfAchievement
                )
            }
        }
    }
}

@Composable
fun CardOfAchievement(
    modifier: Modifier = Modifier,
    reward: Int,
    isCompleted: Boolean,
    type: AchievementType,
    done: Int,
    requirement: Int,
    @StringRes nameOfAchievement: Int,
    @StringRes descriptionOfAchievement: Int,
    @DrawableRes imageOfAchievement: Int
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    ) {
        HorizontalDivider(thickness = 2.dp, color = Color.White)
        Spacer(modifier = Modifier.height(5.dp))

        Row {
            Card {
                Image(
                    painter = painterResource(id = imageOfAchievement),
                    contentDescription = null,
                    modifier = Modifier
                        .size(105.dp)
                        .padding(5.dp)
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            if (!isCompleted) {
                Card(modifier = Modifier.sizeIn(minWidth = 500.dp, minHeight = 105.dp)) {
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
            } else {
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
                    modifier = Modifier.sizeIn(minWidth = 500.dp, minHeight = 105.dp)
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
            }
        }

        /* TODO: Have to implement Progress bar */


        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 2.dp, color = Color.White)
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
fun ProgressBarForAchievement(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxWidth()) {

    }
}

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    currentCoins: Int,
    nextCoins: Int,
    @StringRes zodiacSign: Int
) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val screenWidthPx = with(LocalDensity.current) { screenWidthDp.dp.toPx() }
    val screenHeightPx = with(LocalDensity.current) { screenHeightDp.dp.toPx() }

    val percentage by animateFloatAsState(
        targetValue = currentCoins.toFloat() / nextCoins.toFloat(),
        animationSpec = tween(300),
        label = "floatState"
    )
    val widthOfRectForPermanentConfiguration = if (screenWidthDp <= 500) 700f else 1000f
    val widthOfRect = (if (screenWidthDp <= 500) 700f else 1000f) * percentage

    val startPositionOfAllProgressBarWidth =
        if (screenWidthDp <= 500) screenWidthPx / 5f else screenWidthPx / 3f
    val startPositionOfAllProgressBarHeight =
        if (screenHeightDp <= 2000) screenHeightPx / 15f else screenHeightPx / 25f
    val startPositionForArrow = Offset(
        x = startPositionOfAllProgressBarWidth + widthOfRect - 30f,
        y = startPositionOfAllProgressBarHeight
    )
    val startPositionForRect =
        Offset(x = startPositionOfAllProgressBarWidth, startPositionOfAllProgressBarHeight + 43f)
    val colorOfArrow by animateColorAsState(
        targetValue = percentage.getColor(), label = "colorState"
    )


    Box(modifier = modifier.fillMaxSize()) {
        Text(
            text = stringResource(id = zodiacSign),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopCenter)
                .padding(top = 10.dp)
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRoundRect( // is the background of the rect if the progress less than 100%
                color = Color.LightGray,
                topLeft = startPositionForRect,
                size = Size(widthOfRectForPermanentConfiguration, 15f),
                cornerRadius = CornerRadius(50f)
            )

            drawRoundRect( // is the second rect of the progress. Has been created emphasizing the main rect
                brush = Brush.linearGradient(listOf(Color(0xFF6600FF), Color(0xFF9400D3))),
                topLeft = Offset(startPositionForRect.x - 0.5f, startPositionForRect.y - 0.5f),
                size = Size(widthOfRect + 1f, 16f),
                cornerRadius = CornerRadius(50f)
            )

            drawRoundRect( // is the main rect of the progress
                brush = Brush.linearGradient(listOf(Color(0xFFECE086), Color(0xFFAA7711))),
                topLeft = startPositionForRect,
                size = Size(widthOfRect, 15f),
                cornerRadius = CornerRadius(50f)
            )


            drawPath( // is the second arrow emphasizing a line of the main arrow
                path = Path().apply {
                    moveTo(startPositionForArrow.x, startPositionForArrow.y) // start position
                    cubicTo(
                        startPositionForArrow.x - 4f,
                        startPositionForArrow.y, // draw a line a little lower in order to set the thickness of the arrow on the top
                        startPositionForArrow.x + 50f,
                        startPositionForArrow.y + 42f, // draw a line to the center. Change the first "x" in order to set the thickness of the arrow on the center on the left side
                        startPositionForArrow.x,
                        startPositionForArrow.y + 100f // draw a line to back to the beginning but quite lower
                    )
                    lineTo(
                        startPositionForArrow.x - 3f,
                        startPositionForArrow.y + 105f
                    ) // draw a line a little lower in order to set the thickness of the arrow on the bottom
                    lineTo(
                        startPositionForArrow.x + 35f,
                        startPositionForArrow.y + 50f
                    ) // draw a line to back to the center. Change the first "x" in order to set the thickness of the arrow on the center on the right side
                    close() // we've created a line
                },
                brush = Brush.radialGradient(colors = listOf(Color.Green, Color.Yellow)),
                style = Stroke(width = 5f)
            )

            drawPath( // is the main arrow
                path = Path().apply {
                    moveTo(startPositionForArrow.x, startPositionForArrow.y) // start position
                    cubicTo(
                        startPositionForArrow.x - 4f,
                        startPositionForArrow.y, // draw a line a little lower in order to set the thickness of the arrow on the top
                        startPositionForArrow.x + 50f,
                        startPositionForArrow.y + 42f, // draw a line to the center. Change the first "x" in order to set the thickness of the arrow on the center on the left side
                        startPositionForArrow.x,
                        startPositionForArrow.y + 100f // draw a line to back to the beginning but quite lower
                    )
                    lineTo(
                        startPositionForArrow.x - 3f,
                        startPositionForArrow.y + 105f
                    ) // draw a line a little lower in order to set the thickness of the arrow on the bottom
                    lineTo(
                        startPositionForArrow.x + 35f,
                        startPositionForArrow.y + 50f
                    ) // draw a line to back to the center. Change the first "x" in order to set the thickness of the arrow on the center on the right side
                    close() // we've created a line
                },
                color = colorOfArrow,
                style = Stroke(width = 4f)
            )
        }

        Text(
            text = "$currentCoins |$nextCoins",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopCenter)
                .padding(top = 80.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawArrowPreview() {
    SpaceTheme {
        ProgressBar(currentCoins = 40, nextCoins = 100, zodiacSign = R.string.zodiac_sign_aries)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StatusScreenPreview() {
    SpaceTheme {
        StatusScreen(modifier = Modifier, gameViewModel = viewModel())
    }
}