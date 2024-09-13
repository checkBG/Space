package com.example.space.model

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.space.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _planet = MutableStateFlow(Planet.initPlanet())
    val planet: StateFlow<Planet>
        get() = _planet.asStateFlow()

    private var coinsPerTap: Progress.CoinsPerTap =
        calculateCoinsPerTap(level = planet.value.levelCoinsPerTap)
    private var maxEnergy: Progress.MaxEnergy =
        calculateMaxEnergy(level = planet.value.levelMaxEnergy)
    private var energyPerSecond: Progress.EnergyPerSecond =
        calculateEnergyPerSecond(level = planet.value.levelEnergyPerSecond)
    private var coinsPerSecond: Progress.CoinsPerSecond =
        calculateCoinsPerSecond(level = planet.value.levelCoinsPerSecond)


    private fun updateDependentProperties() {
        planet.value.apply {
            coinsPerTap = calculateCoinsPerTap(level = levelCoinsPerTap)
            maxEnergy = calculateMaxEnergy(level = levelMaxEnergy)
            energyPerSecond = calculateEnergyPerSecond(level = levelEnergyPerSecond)
            coinsPerSecond = calculateCoinsPerSecond(level = levelCoinsPerSecond)
        }
    }

    private fun updateProgressPercentage(): Float {
        return (planet.value.energy.toFloat() / maxEnergy.value.toFloat())
    }

    private fun updateTextTopAppBar(): Int {
        planet.value.apply {
            return when {
                coins < 10 -> R.string.p_coin
                coins < 100 -> R.string.pl_coin
                coins < 1000 -> R.string.pla_coin
                coins < 10000 -> R.string.plan_coin
                coins < 100000 -> R.string.plane_coin
                else -> R.string.planet_coin
            }
        }
    }

    private val coroutineScope =
        CoroutineScope(viewModelScope.coroutineContext + Dispatchers.Default)

    var planetAppBar = mutableIntStateOf(updateTextTopAppBar())
        private set
    val planetBottomAppBar = R.string.planet_bottom

    val upgradeAppBar = R.string.upgrade
    val upgradeBottomAppBar = R.string.upgrade_bottom

    val statusAppBar = R.string.status
    val statusBottomAppBar = R.string.status_bottom

    var progressPercentage = updateProgressPercentage()
        private set

    fun updateCoinsForTap() {
        _planet.apply {
            val currentCoins = value.coins + coinsPerTap.value
            val currentEnergy = value.energy - coinsPerTap.value

            if (value.energy >= coinsPerTap.value) {
                update { currentPlanet ->
                    currentPlanet.copy(
                        coins = currentCoins,
                        energy = currentEnergy
                    )
                }
            } else {
                update { currentPlanet ->
                    currentPlanet.copy(
                        coins = value.coins + value.energy,
                        energy = 0
                    )
                }
            }
            planetAppBar.intValue = updateTextTopAppBar()
            progressPercentage = updateProgressPercentage()
        }
    }

    private fun calculateCoinsPerTap(level: Int): Progress.CoinsPerTap {
        return Progress.CoinsPerTap(
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

    private fun calculateMaxEnergy(level: Int): Progress.MaxEnergy {
        return Progress.MaxEnergy(
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

    private fun calculateEnergyPerSecond(level: Int): Progress.EnergyPerSecond {
        return Progress.EnergyPerSecond(
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

    private fun calculateCoinsPerSecond(level: Int): Progress.CoinsPerSecond {
        return Progress.CoinsPerSecond(
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

    private fun coinIncrease() {
        _planet.apply {
            val updatedCoins = value.coins + coinsPerSecond.value

            update { currentPlanet ->
                currentPlanet.copy(
                    coins = updatedCoins
                )
            }
            planetAppBar.intValue = updateTextTopAppBar()
        }
    }

    private fun isMaxLevel(level: Int): Boolean = level in 1..10
    private fun nextLevel(level: Int): Int? = if (level + 1 <= 10) (level + 1) else null

    val listOfUpdates = listOf(
        UpdateData(
            updatableObject = R.string.coin_per_tap,
            updatableDescription = R.string.coin_per_tap_description,
            updatableImage = R.drawable.coin_with_a_clover_svgrepo_com,
            currentLevel = planet.value.levelCoinsPerTap,
            nextLevel = nextLevel(level = planet.value.levelCoinsPerTap),
            isMaxLevel = isMaxLevel(level = planet.value.levelCoinsPerTap)
        ),
        UpdateData(
            updatableObject = R.string.coin_per_second,
            updatableDescription = R.string.coin_per_second_description,
            updatableImage = R.drawable.money_coin_svgrepo_com,
            currentLevel = planet.value.levelCoinsPerSecond,
            nextLevel = nextLevel(level = planet.value.levelCoinsPerSecond),
            isMaxLevel = isMaxLevel(level = planet.value.levelCoinsPerSecond)
        ),
        UpdateData(
            updatableObject = R.string.max_energy,
            updatableDescription = R.string.max_energy_description,
            updatableImage = R.drawable.battery_svgrepo_com,
            currentLevel = planet.value.levelMaxEnergy,
            nextLevel = nextLevel(level = planet.value.levelMaxEnergy),
            isMaxLevel = isMaxLevel(level = planet.value.levelMaxEnergy)
        ),
        UpdateData(
            updatableObject = R.string.energy_per_second,
            updatableDescription = R.string.energy_per_second_description,
            updatableImage = R.drawable.battery_charge_alert_svgrepo_com,
            currentLevel = planet.value.levelEnergyPerSecond,
            nextLevel = nextLevel(level = planet.value.levelEnergyPerSecond),
            isMaxLevel = isMaxLevel(level = planet.value.levelEnergyPerSecond)
        )
    )


    private fun energyRecovery() {
        _planet.apply {
            val increaseEnergy =
                if ((value.energy + energyPerSecond.value) <= maxEnergy.value) {
                    energyPerSecond.value
                } else {
                    maxEnergy.value - value.energy
                }
            val updatedEnergy = value.energy + increaseEnergy

            update { currentPlanet ->
                currentPlanet.copy(
                    energy = updatedEnergy
                )
            }

            progressPercentage = updateProgressPercentage()
        }
    }

    private suspend fun checkEnergyStatus() {
        if (planet.value.energy >= maxEnergy.value) {
            // Если энергия достигла максимального значения, ждем, пока она не станет меньше
            while (planet.value.energy == maxEnergy.value) {
                delay(100)
            }
        }
    }

    init {
        coroutineScope.launch {
            while (true) {
                delay(1000)
                energyRecovery()
                checkEnergyStatus()
            }
        }
        coroutineScope.launch {
            while (true) {
                delay(1000)
                coinIncrease()
            }
        }
    }
}