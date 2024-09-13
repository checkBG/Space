package com.example.space.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.space.app.bars.BottomBarScreen

data class UpdateData(
    @StringRes val updatableObject: Int,
    @StringRes val updatableDescription: Int,
    @DrawableRes val updatableImage: Int,
    val currentLevel: Int,
    val nextLevel: Int?,
    val isMaxLevel: Boolean
)

sealed class Progress(val value: Int) {
    class CoinsPerTap(value: Int) : Progress(value = value)

    class CoinsPerSecond(value: Int) : Progress(value = value)

    class MaxEnergy(value: Int) : Progress(value = value)

    class EnergyPerSecond(value: Int) : Progress(value = value)
}