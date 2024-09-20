package com.example.space.utils

import androidx.compose.ui.graphics.Color

fun Float.getColor(): Color {
    return when {
        this < 0.01f -> Color(0xFF000000) // Чёрный
        this < 0.03f -> Color(0xFF28071A) // Очень тёмный пурпурный
        this < 0.05f -> Color(0xFF320A18) // Очень тёмный красный
        this < 0.08f -> Color(0xFF5C0000) // Кровавый
        this < 0.12f -> Color(0xFF4D220E) // Глубоко-коричневый
        this < 0.15f -> Color(0xFF92000A) // Бордовый
        this < 0.18f -> Color(0xFFFF2400) // Алый
        this < 0.22f -> Color(0xFFFF2400) // Красный
        this < 0.25f -> Color(0xFFf6768e) // Пурпурно-розовый
        this < 0.28f -> Color(0xFFFF7033) // Желтый
        this < 0.30f -> Color(0xFFC7A600) // Золотой
        this < 0.35f -> Color(0xFFFFD700) // Желто-золотой
        this < 0.40f -> Color(0xFFF8F32B) // Желто-зеленый
        this < 0.45f -> Color(0xFF98FB98) // Бледно-зелёный
        this < 0.50f -> Color(0xFFBFFF00) // Зеленый
        this < 0.55f -> Color(0xFF00FF00) // Светло-зеленый
        this < 0.60f -> Color(0xFF08E8DE) // Глазуритовый
        this < 0.65f -> Color(0xFF00FFFF) // Синий
        this < 0.70f -> Color(0xFF0000FF) // Синий (густой)
        this < 0.75f -> Color(0xFF0047AB) // Индиго
        this < 0.80f -> Color(0xFF002147) // Навыки синего
        this < 0.85f -> Color(0xFF001A33) // Тёмно-синий
        this < 0.90f -> Color(0xFF000033) // Черный с синим оттенком
        else -> Color(0xFF000033) // Тёмно-синий (best)
    }
}