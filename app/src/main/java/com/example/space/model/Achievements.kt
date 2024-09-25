package com.example.space.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.space.R
import com.example.space.model.AchievementTapOnScreen.Companion.requirementValue
import com.example.space.model.AchievementTapOnScreen.Companion.rewardValue

data class Achievement(
    val achievement: AchievementDetail,
    val isCompleted: Boolean = false
) {
//    companion object {
//        fun Achievement.updateUpgradeDataInTheList(): Achievement {
//            return Achievement()
//        }
//    }
}

abstract class AchievementDetail(val level: Int) {
    abstract val requirement: Int
    abstract val reward: Int
    abstract val type: AchievementType

    @get:StringRes
    abstract val nameOfAchievement: Int

    @get:StringRes
    abstract val descriptionOfAchievement: Int

    @get:DrawableRes
    abstract val imageOfAchievement: Int
}

class AchievementSpentMoney(level: Int) : AchievementDetail(level) {
    override val requirement: Int = requirementValue(level = level)
    override val reward: Int = rewardValue(level = level)
    override val type: AchievementType = AchievementType.Spent

    override val nameOfAchievement: Int = 0
    override val descriptionOfAchievement: Int = 0
    override val imageOfAchievement: Int = 0

    companion object {
        private fun requirementValue(level: Int): Int {
            return when(level) {
                1 -> 300
                else -> 100_000_000 /* TODO: Implementing the function */
            }
        }

        private fun rewardValue(level: Int): Int {
            return when(level) {
                1 -> 50
                else -> 1_000_000 /* TODO: Implementing the function */
            }
        }

        fun achievementSpentMoney(level: Int) = AchievementSpentMoney(level = level)
    }
} /* TODO: Implementing the class */

class AchievementTapOnScreen(level: Int) : AchievementDetail(level) {
    override val requirement: Int = requirementValue(level = level)
    override val reward: Int = rewardValue(level = level)
    override val type: AchievementType = AchievementType.Tap

    override val nameOfAchievement: Int = R.string.tap_on_screen
    override val descriptionOfAchievement: Int = R.string.tap_on_screen_description
    override val imageOfAchievement: Int = R.drawable.tap_svgrepo_com

    companion object {
        private fun requirementValue(level: Int): Int {
            return when (level) {
                1 -> 100
                2 -> 500
                3 -> 1000
                4 -> 7500
                5 -> 15000
                6 -> 23000
                7 -> 50000
                8 -> 150_000
                9 -> 500_000
                else -> 1_000_000
            }
        }

        private fun rewardValue(level: Int): Int {
            return when (level) {
                1 -> 300
                2 -> 500
                3 -> 1400
                4 -> 3000
                5 -> 6000
                6 -> 8000
                7 -> 14000
                8 -> 30000
                9 -> 100_000
                else -> 230_000
            }
        }

        fun achievementTapOnScreen(level: Int) = AchievementTapOnScreen(level = level)
    }
}

data class Status(
    val countOfTapsOnScreen: Int = 0,
    val countOfSpentMoney: Int = 0,
    val countOfRecoveredEnergy: Int = 0,
    val countOfUpgradedCards: Int = 0
)


enum class AchievementType() {
    Tap,
    Spent,
    Recovery,
    Upgrade
}