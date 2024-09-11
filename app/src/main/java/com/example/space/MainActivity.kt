package com.example.space

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.space.fundamental.CountOfCoinsRow
import com.example.space.fundamental.CustomProgressBar
import com.example.space.fundamental.SpaceApp
import com.example.space.fundamental.SpaceBackground
import com.example.space.fundamental.SpaceButtonImageCenter
import com.example.space.ui.theme.SpaceTheme

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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CountOfCoinsRowPreview() {
    SpaceTheme(darkTheme = true) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            CountOfCoinsRow(
                currentCoins = 10,
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