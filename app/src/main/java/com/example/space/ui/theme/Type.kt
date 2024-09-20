package com.example.space.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.space.R

val YesevaOneRegular = FontFamily(
    Font(R.font.yeseva_one_regular)
)

val EaterRegular = FontFamily(
    Font(R.font.eater_regular)
)

val fascinate_inline_regular = FontFamily(
    Font(R.font.fascinate_inline_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = fascinate_inline_regular,
        fontWeight = FontWeight.Normal,
        fontSize = 35.sp
    ),
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 42.sp
    ),
    displayMedium = TextStyle(
        fontFamily = EaterRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
//        drawStyle = Stroke(
//            miter = 3f,
//            width = 3f,
//            join = StrokeJoin.Round
//        )
    ),
    displaySmall = TextStyle(
        fontFamily = YesevaOneRegular,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)