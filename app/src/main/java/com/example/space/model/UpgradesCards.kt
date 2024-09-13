package com.example.space.model

import androidx.annotation.StringRes

//object UpgradesCards {
//    val listOfUpdates = listOf(
//
//    )
//}

data class UpdateData(
    @StringRes val updatableObject: Int,
    @StringRes val updatableDescription: Int,
//    val
)

sealed class Progress(val value: Int) {
    class CoinsPerTap(value: Int) : Progress(value = value)

    class CoinsPerSecond(value: Int) : Progress(value = value)

    class MaxEnergy(value: Int) : Progress(value = value)

    class EnergyPerSecond(value: Int) : Progress(value = value)
}