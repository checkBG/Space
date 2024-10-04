package com.example.space.fundamental

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.space.R
import com.example.space.model.GameViewModel
import com.example.space.ui.theme.SpaceTheme
import com.example.space.utils.SpaceScreenSize
import java.util.Locale
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

@Composable
fun PlanetScreen(
    modifier: Modifier = Modifier,
    screenSize: SpaceScreenSize,
    gameViewModel: GameViewModel
) {
    val gamePlanetState by gameViewModel.planet.collectAsState()


    Box(modifier = modifier) {
        SpaceBackground()

        SpaceButtonImageCenter(
            onClick = { gameViewModel.updateCoinsForTap() },
            screenSize = screenSize
        )

        CountOfCoinsRow(
            currentCoins = gamePlanetState.coins,
            progressPercentage = gameViewModel.progressPercentage,
            screenSize = screenSize
        )

    }
}

@Composable
private fun CustomProgressBar(
    modifier: Modifier = Modifier,
    screenSize: SpaceScreenSize,
    progressPercentage: Float = 1.0f
) {
    val image = ImageBitmap.imageResource(id = R.drawable.moon_png42)

    val sizeImageBelowCanvas = when (screenSize) {
        SpaceScreenSize.Small -> 90.dp
        SpaceScreenSize.Medium -> 110.dp
        SpaceScreenSize.Large -> 120.dp
    }

    val thickness = when(screenSize) {
        SpaceScreenSize.Small -> 10.dp
        SpaceScreenSize.Medium -> 12.dp
        SpaceScreenSize.Large -> 13.5.dp
    }

    val sizeOfCanvas = when(screenSize) {
        SpaceScreenSize.Small -> 110.dp
        SpaceScreenSize.Medium -> 125.dp
        SpaceScreenSize.Large -> 145.dp
    }

    val indicatorSize = when(screenSize) {
        SpaceScreenSize.Small -> 25
        SpaceScreenSize.Medium -> 28
        SpaceScreenSize.Large -> 33
    }

    Box(
        modifier = modifier
            .padding(end = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = null,
            modifier = Modifier
                .size(sizeImageBelowCanvas)
                .align(alignment = Alignment.Center)
        )

        Canvas(
            modifier = Modifier
                .size(sizeOfCanvas), onDraw = {
                // background arc
                drawArc(
                    color = Color.Gray,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    style = Stroke(width = thickness.toPx(), cap = StrokeCap.Round),
                    size = Size(size.width, size.height)
                )

                // foreground arc
                drawArc(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFFF984A),
                            Color(0xFFEF8E38),
                            Color(0xFFFFBE63)
                        )
                    ),
                    startAngle = 180f,
                    sweepAngle = progressPercentage * 180f,
                    useCenter = false,
                    style = Stroke(width = thickness.toPx(), cap = StrokeCap.Round),
                    size = Size(size.width, size.height)
                )

                val angleInDegrees = (progressPercentage * 180.0) + 90.0
                val radius = (size.height / 2)
                val x =
                    -(radius * sin(Math.toRadians(angleInDegrees))).toFloat() + ((size.width - indicatorSize) / 2)
                val y =
                    (radius * cos(Math.toRadians(angleInDegrees))).toFloat() + ((size.height - indicatorSize) / 2)

                // icon for split
//            drawCircle(
//                color = Color.White,
//                radius = 5f,
//                center = Offset(x, y)
//            )

                // icon for split
                drawImage(
                    image = image,
                    dstSize = IntSize(indicatorSize, indicatorSize),
                    dstOffset = IntOffset(x.roundToInt(), y.roundToInt())
                )
            })
    }
}

@Composable
fun CountOfCoinsRow(
    screenSize: SpaceScreenSize,
    currentCoins: Int,
    modifier: Modifier = Modifier,
    progressPercentage: Float = 1.0f
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 130.dp)
    ) {
        CustomProgressBar(progressPercentage = progressPercentage, screenSize = screenSize)

        Text(
            text = String.format(Locale.getDefault(), "%,d", currentCoins),
            style = MaterialTheme.typography.displayLarge,
            color = colorResource(id = R.color.sun),
            fontSize = when (screenSize) {
                SpaceScreenSize.Small -> 33.sp
                SpaceScreenSize.Medium -> 42.sp
                SpaceScreenSize.Large -> 60.sp
            },
            modifier = Modifier
        )
    }
}

@Composable
fun SpaceBackground(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.spaceful),
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@SuppressLint("ReturnFromAwaitPointerEventScope")
@Composable
fun SpaceButtonImageCenter(
    screenSize: SpaceScreenSize,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isScalePlanetSize by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isScalePlanetSize) 0.94f else 1f, label = "")
    val sizeOfPlanet = when (screenSize) {
        SpaceScreenSize.Small -> 240.dp
        SpaceScreenSize.Medium -> 300.dp
        SpaceScreenSize.Large -> 340.dp
    }

    Image(
        painter = painterResource(id = R.drawable.click_planet),
        contentDescription = null,
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.Center)
            .pointerInput(isScalePlanetSize) {
                awaitPointerEventScope {
                    isScalePlanetSize = if (isScalePlanetSize) {
                        waitForUpOrCancellation()
                        false
                    } else {
                        awaitFirstDown(requireUnconsumed = false)
                        true
                    }
                }
            }
            .scale(scale = scale)
            .size(sizeOfPlanet)
            .clip(shape = MaterialTheme.shapes.small)
            .clickable(
                onClick = onClick,
//                onLongClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountOfCoinsRowPreview() {
    SpaceTheme(darkTheme = true) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CountOfCoinsRow(
                currentCoins = 10,
                modifier = Modifier.padding(innerPadding),
                screenSize = SpaceScreenSize.Small
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpaceImageCenterPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SpaceButtonImageCenter(
                onClick = { },
                modifier = Modifier.padding(innerPadding),
                screenSize = SpaceScreenSize.Small
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SpaceBackgroundPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SpaceBackground(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomProgressBarPreview() {
    SpaceTheme {
        Surface(
            modifier = Modifier
        ) {
            CustomProgressBar(screenSize = SpaceScreenSize.Small)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceAppCompactPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            PlanetScreen(
                modifier = Modifier.padding(innerPadding),
                gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Small
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun SpaceAppMediumPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            PlanetScreen(
                modifier = Modifier.padding(innerPadding),
                gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Medium
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun SpaceAppLargePreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            PlanetScreen(
                modifier = Modifier.padding(innerPadding),
                gameViewModel = viewModel(),
                screenSize = SpaceScreenSize.Large
            )
        }
    }
}

