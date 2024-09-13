package com.example.space.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class UpdateData(
    @StringRes val updatableObject: Int,
    @StringRes val updatableDescription: Int,
    @DrawableRes val updatableImage: Int,
    val currentLevel: Int,
    val nextLevel: Int?,
    val isMaxLevel: Boolean,
    val requiredToUp: Int,
    val onClick: (Int, Int, Int) -> Unit
)

sealed class Progress(val value: Int, val index: Int) {
    class CoinsPerTap(value: Int, index: Int = 0) : Progress(value = value, index = index)

    class CoinsPerSecond(value: Int, index: Int = 1) : Progress(value = value, index = index)

    class MaxEnergy(value: Int, index: Int = 2) : Progress(value = value, index = index)

    class EnergyPerSecond(value: Int, index: Int = 3) : Progress(value = value, index = index)
}