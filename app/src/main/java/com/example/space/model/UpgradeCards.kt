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
    val onClick: (Int, Int) -> Unit,
    val updateData: UpgradeCards
) {
    companion object {
        fun UpdateData.updateUpgradeDataInTheList(level: Int): UpdateData {
            return this.copy(
                currentLevel = level,
                nextLevel = Progress.nextLevel(level = level),
                isMaxLevel = Progress.isMaxLevel(level = level),
                requiredToUp = Progress.requiredToUp(level = level)
            )
        }
    }
}

sealed class Progress(val value: Int) {
    class CoinsPerTap(value: Int) : Progress(value = value) {
        companion object {
            fun progressUpdate(level: Int) = CoinsPerTap(
                value = when (level) {
                    1 -> 3
                    2 -> 5
                    3 -> 7
                    4 -> 9
                    5 -> 11
                    6 -> 13
                    7 -> 15
                    8 -> 17
                    9 -> 19
                    else -> 20
                }
            )
        }
    }

    class CoinsPerSecond(value: Int) : Progress(value = value) {
        companion object {
            fun progressUpdate(level: Int) = CoinsPerSecond(
                value = when (level) {
                    1 -> 1
                    2 -> 1
                    3 -> 1
                    4 -> 2
                    5 -> 2
                    6 -> 2
                    7 -> 3
                    8 -> 3
                    9 -> 3
                    else -> 4
                }
            )
        }
    }

    class MaxEnergy(value: Int) : Progress(value = value) {
        companion object {
            fun progressUpdate(level: Int) = MaxEnergy(
                value = when (level) {
                    1 -> 500
                    2 -> 1000
                    3 -> 1500
                    4 -> 2000
                    5 -> 2500
                    6 -> 3000
                    7 -> 3500
                    8 -> 4000
                    9 -> 4500
                    else -> 5000
                }
            )
        }
    }

    class EnergyPerSecond(value: Int) : Progress(value = value) {
        companion object {
            fun progressUpdate(level: Int) = EnergyPerSecond(
                value = when (level) {
                    1 -> 3
                    2 -> 4
                    3 -> 5
                    4 -> 6
                    5 -> 7
                    6 -> 8
                    7 -> 9
                    8 -> 10
                    9 -> 11
                    else -> 12
                }
            )
        }
    }

    companion object {
        fun requiredToUp(level: Int): Int = when (level) {
            1 -> 100
            2 -> 500
            3 -> 1000
            4 -> 2000
            5 -> 4000
            6 -> 10_000
            7 -> 25_000
            8 -> 35_000
            9 -> 50_000
            else -> 100_000
        }

        fun nextLevel(level: Int): Int? =
            if (level.inc() in rangeOfLevels) level.inc() else null

        fun isMaxLevel(level: Int): Boolean = level in rangeOfLevels
    }
}

enum class UpgradeCards {
    CoinsPerSecond,
    CoinsPerTap,
    MaxEnergy,
    EnergyPerSecond
}