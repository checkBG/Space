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
    private val _planet = MutableStateFlow(Planet())
    val planet: StateFlow<Planet>
        get() = _planet.asStateFlow()

    private fun updateProgressPercentage(): Float {
        return (planet.value.energy.toFloat() / planet.value.maxEnergy.toFloat())
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
        coroutineScope.launch {
            _planet.apply {
                val currentCoins = value.coins + value.coinsPerTap
                val currentEnergy = value.energy - value.coinsPerTap

                if (value.energy >= value.coinsPerTap) {
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
    }

    private fun energyRecovery() {
        coroutineScope.launch {
            _planet.apply {
                val increaseEnergy =
                    if ((value.energy + value.energyPerSecond) <= value.maxEnergy) {
                        value.energyPerSecond
                    } else {
                        value.maxEnergy - value.energy
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
    }

    private suspend fun checkEnergyStatus() {
        if (planet.value.energy >= planet.value.maxEnergy) {
            // Если энергия достигла максимального значения, ждем, пока она не станет меньше
            while (planet.value.energy == planet.value.maxEnergy) {
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
    }
}