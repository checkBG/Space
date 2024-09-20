package com.example.space.Utils

import androidx.compose.ui.graphics.Color

fun Float.getColor(): Color {
    return when {
        this < 0.1f -> Color(0xFF92000A)
        this < 0.2f -> Color(0xFFFF2400)
        this < 0.3f -> Color(0xFFFF7033)
        this < 0.4f -> Color(0xFFC7A600)
        this < 0.5f -> Color(0xFFFFD700)
        this < 0.6f -> Color(0xFFF8F32B)
        this < 0.7f -> Color(0xFFBFFF00)
        this < 0.8f -> Color(0xFF00FF00)
        this < 0.9f -> Color(0xFF08E8DE)
        else -> Color(0xFF00FFFF)
    }
}