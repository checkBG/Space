package com.example.space.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Achievement(
    val requirement: Int,
    val achievement: Int,
    val reward: Int,
    val isCompleted: Boolean = false,
    @StringRes val nameOfAchievement: Int,
    @StringRes val descriptionOfAchievement: Int,
    @DrawableRes val imageOfAchievement: Int
) {
//    companion object {
//        fun Achievement.updateUpgradeDataInTheList(): Achievement {
//            return Achievement()
//        }
//    }
}

data class Status(
    val countOfTapsOnScreen: Int = 0,
    val countOfSpentMoney: Int = 0,
    val countOfRecoveredEnergy: Int = 0,
    val countOfUpgradedCards: Int = 0
)
//
//enum class AchievementCard() {
//    Tap,
//    Spent,
//}