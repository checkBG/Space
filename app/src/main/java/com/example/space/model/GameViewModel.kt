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

    private var coinsPerTap: Int =
        calculateCoinsPerTap(level = planet.value.levelCoinsPerTap)
    private var maxEnergy: Int = calculateMaxEnergy(level = planet.value.levelMaxEnergy)
    private var energyPerSecond: Int =
        calculateEnergyPerSecond(level = planet.value.levelEnergyPerSecond)
    private var coinsPerSecond: Int =
        calculateCoinsPerSecond(level = planet.value.levelCoinsPerSecond)


    private fun updateDependentProperties() {
        planet.value.apply {
            coinsPerTap = calculateCoinsPerTap(level = levelCoinsPerTap)
            maxEnergy = calculateMaxEnergy(level = levelMaxEnergy)
            energyPerSecond = calculateEnergyPerSecond(level = levelEnergyPerSecond)
            coinsPerSecond = calculateEnergyPerSecond(level = levelCoinsPerSecond)
        }
    }

    private fun updateProgressPercentage(): Float {
        return (planet.value.energy.toFloat() / maxEnergy.toFloat())
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

    var textTopAppBar = mutableIntStateOf(updateTextTopAppBar())
        private set

    var progressPercentage = updateProgressPercentage()
        private set

    fun updateCoinsForTap() {
        _planet.apply {
            val currentCoins = value.coins + coinsPerTap
            val currentEnergy = value.energy - coinsPerTap

            if (value.energy >= coinsPerTap) {
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
            textTopAppBar.intValue = updateTextTopAppBar()
            progressPercentage = updateProgressPercentage()
        }
    }

    private fun calculateCoinsPerTap(level: Int): Int {
        return when (level) {
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
    }

    private fun calculateMaxEnergy(level: Int): Int {
        return when (level) {
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
    }

    private fun calculateEnergyPerSecond(level: Int): Int {
        return when (level) {
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
    }

    private fun calculateCoinsPerSecond(level: Int): Int {
        return when (level) {
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
    }

    private fun coinIncrease() {
        _planet.apply {
            val updatedCoins = value.coins + coinsPerSecond

            update { currentPlanet ->
                currentPlanet.copy(
                    coins = updatedCoins
                )
            }
        }
    }

    private fun energyRecovery() {
        _planet.apply {
            val increaseEnergy =
                if ((value.energy + energyPerSecond) <= maxEnergy) {
                    energyPerSecond
                } else {
                    maxEnergy - value.energy
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
        if (planet.value.energy >= maxEnergy) {
            // Если энергия достигла максимального значения, ждем, пока она не станет меньше
            while (planet.value.energy == maxEnergy) {
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