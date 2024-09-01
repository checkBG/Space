package com.example.space

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.space.fundamental.Planet
import com.example.space.ui.theme.SpaceTheme
import java.util.Locale
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SpaceApp()
                }
            }
        }
    }
}

@Composable
fun SpaceApp(modifier: Modifier = Modifier) {
    var coins by rememberSaveable { mutableIntStateOf(0) }
    var energy by rememberSaveable { mutableIntStateOf(500) }

    val planet = Planet(coins = coins, energy = energy)

//    planet.addedEnergy(energy = energy, add = { energy += planet.coinsForTap })

    Scaffold(
        topBar = {
            SpaceTopAppBar(coins = planet.countOfCoins)
        },
        bottomBar = {
            BottomAppBarIcons()
        }
    ) { innerPadding ->
        @Suppress("UNUSED_VARIABLE") val inPadding = innerPadding

        Box(modifier = modifier) {
            SpaceBackground()

            SpaceButtonImageCenter(
                onClick = {
                    if (energy >= planet.coinsForTap) {
                        coins += planet.coinsForTap
                        energy -= planet.coinsForTap
                    }
                }
            )

            CountOfCoinsRow(
                planet = planet,
                modifier = Modifier
            )

        }
    }
}

@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
    progressPercentage: Float = 1.0f
) {
    val image = ImageBitmap.imageResource(id = R.drawable.moon)
    val widthImage = 20
    val heightImage = 20

    Box(
        modifier = modifier
            .padding(end = 20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.sun),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .align(alignment = Alignment.Center)
//                .padding(20.dp)
//                .padding(end = 16.dp)
        )

        Canvas(
            modifier = Modifier
                .size(110.dp), onDraw = {
                // background arc
                drawArc(
                    color = Color.Gray,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    style = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round),
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
                    style = Stroke(width = 10.dp.toPx(), cap = StrokeCap.Round),
                    size = Size(size.width, size.height)
                )

                val angleInDegrees = (progressPercentage * 180.0) + 90.0
                val radius = (size.height / 2)
                val x =
                    -(radius * sin(Math.toRadians(angleInDegrees))).toFloat() + ((size.width - widthImage) / 2)
                val y =
                    (radius * cos(Math.toRadians(angleInDegrees))).toFloat() + ((size.height - heightImage) / 2)

                // icon for split
//            drawCircle(
//                color = Color.White,
//                radius = 5f,
//                center = Offset(x, y)
//            )

                // icon for split
                drawImage(
                    image = image,
                    dstSize = IntSize(widthImage, heightImage),
                    dstOffset = IntOffset(x.roundToInt(), y.roundToInt())
                )
            })
    }
}

@Composable
fun BottomAppBarIcons() {
    NavigationBar(
        containerColor = Color.Transparent,
        modifier = Modifier.fillMaxWidth()
    ) {
//        Spacer(modifier = Modifier.weight(1f, fill = true))
//
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                painter = painterResource(id = R.drawable.planet_zastavka_tini),
//                contentDescription = stringResource(id = R.string.clicker),
//                tint = Color.Unspecified,
//                modifier = Modifier.size(42.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f, fill = true))
//
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                painter = painterResource(id = R.drawable.star),
//                contentDescription = stringResource(R.string.pumping_content),
//                tint = Color.Unspecified,
//                modifier = Modifier.size(42.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f, fill = true))
//
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(
//                painter = painterResource(id = R.drawable.exchange),
//                contentDescription = stringResource(R.string.exchange_content),
//                tint = Color.Unspecified,
//                modifier = Modifier.size(42.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.weight(1f, fill = true))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceTopAppBar(coins: Int) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = when {
                    coins < 10 -> stringResource(id = R.string.p_coin)
                    coins < 100 -> stringResource(id = R.string.pl_coin)
                    coins < 1000 -> stringResource(id = R.string.pla_coin)
                    coins < 10000 -> stringResource(id = R.string.plan_coin)
                    coins < 100000 -> stringResource(id = R.string.plane_coin)
                    else -> stringResource(id = R.string.planet_coin)
                },
//                text = stringResource(R.string.planet_coin),
                color = colorResource(id = R.color.persian_blue),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentWidth(align = Alignment.End)
//                    .padding(end = 20.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null, tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent.copy(alpha = 0.7f)
        )
    )
}

@Composable
fun CountOfCoinsRow(planet: Planet, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 130.dp)
    ) {
        CustomProgressBar(progressPercentage = (planet.energy.toFloat() / planet.maxEnergy.toFloat()))

        Text(
            text = String.format(Locale.getDefault(), "%,d", planet.countOfCoins),
            style = MaterialTheme.typography.displayLarge,
            color = colorResource(id = R.color.sun),
            modifier = Modifier
        )
    }
}

@Composable
fun SpaceBackground(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.background_space),
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@SuppressLint("ReturnFromAwaitPointerEventScope")
@Composable
fun SpaceButtonImageCenter(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var isScalePlanetSize by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(targetValue = if (isScalePlanetSize) 0.94f else 1f, label = "")

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
            .size(240.dp)
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
                planet = Planet(coins = 10, energy = 500),
                modifier = Modifier.padding(innerPadding)
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
                modifier = Modifier.padding(innerPadding)
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
fun SpaceAppPreview() {
    SpaceTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            SpaceApp(modifier = Modifier.padding(innerPadding))
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
            CustomProgressBar()
        }
    }
}