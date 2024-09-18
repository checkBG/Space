package com.example.space.model

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.space.R
import com.example.space.model.UpdateData.Companion.updateUpgradeDataInTheList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

val rangeOfLevels = 1..10

class GameViewModel : ViewModel() {
    private val _planet = MutableStateFlow(Planet.initPlanet())
    val planet: StateFlow<Planet>
        get() = _planet.asStateFlow()

    private var coinsPerTap: Progress.CoinsPerTap =
        Progress.CoinsPerTap.progressUpdate(level = planet.value.levelCoinsPerTap)
    private var maxEnergy: Progress.MaxEnergy =
        Progress.MaxEnergy.progressUpdate(level = planet.value.levelMaxEnergy)
    private var energyPerSecond: Progress.EnergyPerSecond =
        Progress.EnergyPerSecond.progressUpdate(level = planet.value.levelEnergyPerSecond)
    private var coinsPerSecond: Progress.CoinsPerSecond =
        Progress.CoinsPerSecond.progressUpdate(level = planet.value.levelCoinsPerSecond)


    private fun updateDependentProperties() {
        planet.value.apply {
            coinsPerTap = Progress.CoinsPerTap.progressUpdate(level = levelCoinsPerTap)
            maxEnergy = Progress.MaxEnergy.progressUpdate(level = levelMaxEnergy)
            energyPerSecond = Progress.EnergyPerSecond.progressUpdate(level = levelEnergyPerSecond)
            coinsPerSecond = Progress.CoinsPerSecond.progressUpdate(level = levelCoinsPerSecond)
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

    val shopAppBar = R.string.shop
    val shopBottomAppBar = R.string.shop_bottom

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

    private val _listOfUpdates = MutableStateFlow(mutableListOf(
        UpdateData(
            updatableObject = R.string.coin_per_tap,
            updatableDescription = R.string.coin_per_tap_description,
            updatableImage = R.drawable.coin_with_a_clover_svgrepo_com,
            currentLevel = planet.value.levelCoinsPerTap,
            nextLevel = Progress.nextLevel(level = planet.value.levelCoinsPerTap),
            isMaxLevel = Progress.isMaxLevel(level = planet.value.levelCoinsPerTap),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelCoinsPerTap),
            updateData = UpgradeCards.CoinsPerTap,
            onClick = { index, requiredToUp, nextLevel ->
                upgradeProgress(
                    requiredToUp = requiredToUp,
                    nextLevel = nextLevel,
                    index = index
                )
            }
        ),
        UpdateData(
            updatableObject = R.string.coin_per_second,
            updatableDescription = R.string.coin_per_second_description,
            updatableImage = R.drawable.money_coin_svgrepo_com,
            currentLevel = planet.value.levelCoinsPerSecond,
            nextLevel = Progress.nextLevel(level = planet.value.levelCoinsPerSecond),
            isMaxLevel = Progress.isMaxLevel(level = planet.value.levelCoinsPerSecond),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelCoinsPerSecond),
            updateData = UpgradeCards.CoinsPerSecond,
            onClick = { index, requiredToUp, nextLevel ->
                upgradeProgress(
                    requiredToUp = requiredToUp,
                    nextLevel = nextLevel,
                    index = index
                )
            }
        ),
        UpdateData(
            updatableObject = R.string.max_energy,
            updatableDescription = R.string.max_energy_description,
            updatableImage = R.drawable.battery_svgrepo_com,
            currentLevel = planet.value.levelMaxEnergy,
            nextLevel = Progress.nextLevel(level = planet.value.levelMaxEnergy),
            isMaxLevel = Progress.isMaxLevel(level = planet.value.levelMaxEnergy),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelMaxEnergy),
            updateData = UpgradeCards.MaxEnergy,
            onClick = { index, requiredToUp, nextLevel ->
                upgradeProgress(
                    requiredToUp = requiredToUp,
                    nextLevel = nextLevel,
                    index = index
                )
            }
        ),
        UpdateData(
            updatableObject = R.string.energy_per_second,
            updatableDescription = R.string.energy_per_second_description,
            updatableImage = R.drawable.battery_charge_alert_svgrepo_com,
            currentLevel = planet.value.levelEnergyPerSecond,
            nextLevel = Progress.nextLevel(level = planet.value.levelEnergyPerSecond),
            isMaxLevel = Progress.isMaxLevel(level = planet.value.levelEnergyPerSecond),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelEnergyPerSecond),
            updateData = UpgradeCards.EnergyPerSecond,
            onClick = { index, requiredToUp, nextLevel ->
                upgradeProgress(
                    requiredToUp = requiredToUp,
                    nextLevel = nextLevel,
                    index = index
                )
            }
        )
    ))
    val listOfUpdates
        get() = _listOfUpdates

    private fun upgradeProgress(requiredToUp: Int, nextLevel: Int, index: Int) {
        val updatedProgress = _listOfUpdates.value[index]

        if (planet.value.coins >= requiredToUp) {
            updatedProgress.apply {
                val updatedCoins = planet.value.coins - requiredToUp
                _planet.update { currentPlanet ->
                    currentPlanet.copy(
                        coins = updatedCoins,
                        levelMaxEnergy = if (this.updateData == UpgradeCards.MaxEnergy) this.nextLevel ?: 10 else currentPlanet.levelMaxEnergy,
                        levelCoinsPerTap = if (this.updateData == UpgradeCards.CoinsPerTap) this.nextLevel ?: 10 else currentPlanet.levelCoinsPerTap,
                        levelCoinsPerSecond = if (this.updateData == UpgradeCards.CoinsPerSecond) this.nextLevel ?: 10 else currentPlanet.levelCoinsPerSecond,
                        levelEnergyPerSecond = if (this.updateData == UpgradeCards.EnergyPerSecond) this.nextLevel ?: 10 else currentPlanet.levelEnergyPerSecond,
                    )
                }
                updateDependentProperties()
                _listOfUpdates.value[index] = this.updateUpgradeDataInTheList(level = this.nextLevel ?: 10)
            }
        }
    }

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
            // if energy reach the max value, we're waiting until it'll be got less
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