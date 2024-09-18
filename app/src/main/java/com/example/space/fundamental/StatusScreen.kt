package com.example.space.fundamental

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.R
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme

@Composable
fun StatusScreen(
    modifier: Modifier = Modifier,
    gameViewModel: GameViewModel
) {
    val gamePlanetState by gameViewModel.planet.collectAsState()

    Box {
        StatusScreenBackground()


        ProgressBar(modifier = modifier, currentCoins = gamePlanetState.coins, nextCoins = 100) // change later!!
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
fun ProgressBar(modifier: Modifier = Modifier, currentCoins: Int, nextCoins: Int) {
    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val screenHeightDp = configuration.screenHeightDp

    val screenWidthPx = with(LocalDensity.current) { screenWidthDp.dp.toPx() }
    val screenHeightPx = with(LocalDensity.current) { screenHeightDp.dp.toPx() }

    val percentage = currentCoins.toFloat() / nextCoins.toFloat()
    val widthOfRectForPermanentConfiguration = if (screenWidthDp <= 500) 700f else 1000f
    val widthOfRect = (if (screenWidthDp <= 500) 700f else 1000f) * percentage

    val startPositionOfAllProgressBarWidth = if (screenWidthDp <= 500) screenWidthPx / 5f else screenWidthPx / 3f
    val startPositionOfAllProgressBarHeight = if (screenHeightDp <= 2000) screenHeightPx / 15f else screenHeightPx / 25f
    val startPositionForArrow = Offset(
        x = startPositionOfAllProgressBarWidth + widthOfRect - 30f,
        y = startPositionOfAllProgressBarHeight
    )
    val startPositionForRect = Offset(x = startPositionOfAllProgressBarWidth, startPositionOfAllProgressBarHeight + 43f)


    Canvas(modifier = modifier.fillMaxSize()) {
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
            brush = Brush.radialGradient(colors = listOf(Color.Green, Color.Cyan)),
            style = Stroke(width = 4f)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DrawArrowPreview() {
    SpaceTheme {
        ProgressBar(currentCoins = 10, nextCoins = 100)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun StatusScreenPreview() {
    SpaceTheme {
        StatusScreen(modifier = Modifier, gameViewModel = viewModel())
    }
}