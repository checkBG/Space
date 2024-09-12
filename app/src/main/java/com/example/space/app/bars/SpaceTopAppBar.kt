package com.example.space.app.bars

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.example.space.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceTopAppBar(
    @StringRes textTopAppBar: Int,
    @ColorRes color: Int,
    style: TextStyle
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = textTopAppBar),
                color = colorResource(id = color),
                style = style,
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