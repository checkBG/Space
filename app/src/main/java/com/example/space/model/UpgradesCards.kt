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

interface CoinsPerTap { val level: Int }

interface CoinsPerSecond { val level: Int }

interface MaxEnergyLevel { val level: Int }

interface EnergyPerSecond { val level: Int }
