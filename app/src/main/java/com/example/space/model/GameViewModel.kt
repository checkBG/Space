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

private val rangeOfLevels = 1..10

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

    private fun isMaxLevel(level: Int): Boolean = level in rangeOfLevels
    private fun nextLevel(level: Int): Int? =
        if (level.inc() in rangeOfLevels) level.inc() else null

    private val _listOfUpdates = MutableStateFlow(mutableListOf(
        UpdateData(
            updatableObject = R.string.coin_per_tap,
            updatableDescription = R.string.coin_per_tap_description,
            updatableImage = R.drawable.coin_with_a_clover_svgrepo_com,
            currentLevel = planet.value.levelCoinsPerTap,
            nextLevel = nextLevel(level = planet.value.levelCoinsPerTap),
            isMaxLevel = isMaxLevel(level = planet.value.levelCoinsPerTap),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelCoinsPerTap),
            onClick = { index, requiredToUp, nextLevel ->
                upgradeCoinsPerTap(
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
            nextLevel = nextLevel(level = planet.value.levelCoinsPerSecond),
            isMaxLevel = isMaxLevel(level = planet.value.levelCoinsPerSecond),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelCoinsPerSecond),
            onClick = { index, requiredToUp, nextLevel ->
                upgradeCoinsPerSecond(
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
            nextLevel = nextLevel(level = planet.value.levelMaxEnergy),
            isMaxLevel = isMaxLevel(level = planet.value.levelMaxEnergy),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelMaxEnergy),
            onClick = { index, requiredToUp, nextLevel ->
                upgradeMaxEnergy(
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
            nextLevel = nextLevel(level = planet.value.levelEnergyPerSecond),
            isMaxLevel = isMaxLevel(level = planet.value.levelEnergyPerSecond),
            requiredToUp = Progress.requiredToUp(level = planet.value.levelEnergyPerSecond),
            onClick = { index, requiredToUp, nextLevel ->
                upgradeEnergyPerSecond(
                    requiredToUp = requiredToUp,
                    nextLevel = nextLevel,
                    index = index
                )
            }
        )
    ))
    val listOfUpdates
        get() = _listOfUpdates

    private fun upgradeCoinsPerTap(requiredToUp: Int, nextLevel: Int, index: Int) {
        // here we don't have to require that our current coins more than need
        // because we'll make a button disabled if any
        // I do it just in case
        if (planet.value.coins >= requiredToUp) {
            val updatedCoins = planet.value.coins - requiredToUp
            _planet.update { currentPlanet ->
                currentPlanet.copy(levelCoinsPerTap = nextLevel, coins = updatedCoins)
            }
            updateDependentProperties()
            _listOfUpdates.value[index] =
                _listOfUpdates.value[index].updateUpgradeDataInTheList(level = planet.value.levelCoinsPerTap)
        }
    }

    private fun upgradeCoinsPerSecond(requiredToUp: Int, nextLevel: Int, index: Int) {
        // here we don't have to require that our current coins more than need
        // because we'll make a button disabled if any
        // I do it just in case
        if (planet.value.coins >= requiredToUp) {
            val updatedCoins = planet.value.coins - requiredToUp
            _planet.update { currentPlanet ->
                currentPlanet.copy(levelCoinsPerSecond = nextLevel, coins = updatedCoins)
            }
            updateDependentProperties()
            _listOfUpdates.value[index] =
                _listOfUpdates.value[index].updateUpgradeDataInTheList(level = planet.value.levelCoinsPerSecond)
        }
    }

    private fun upgradeMaxEnergy(requiredToUp: Int, nextLevel: Int, index: Int) {
        // here we don't have to require that our current coins more than need
        // because we'll make a button disabled if any
        // I do it just in case
        if (planet.value.coins >= requiredToUp) {
            val updatedCoins = planet.value.coins - requiredToUp
            _planet.update { currentPlanet ->
                currentPlanet.copy(levelMaxEnergy = nextLevel, coins = updatedCoins)
            }
            updateDependentProperties()
            _listOfUpdates.value[index] =
                _listOfUpdates.value[index].updateUpgradeDataInTheList(level = planet.value.levelMaxEnergy)
        }
    }

    private fun upgradeEnergyPerSecond(requiredToUp: Int, nextLevel: Int, index: Int) {
        // here we don't have to require that our current coins more than need
        // because we'll make a button disabled if any
        // I do it just in case
        if (planet.value.coins >= requiredToUp) {
            val updatedCoins = planet.value.coins - requiredToUp
            _planet.update { currentPlanet ->
                currentPlanet.copy(levelEnergyPerSecond = nextLevel, coins = updatedCoins)
            }
            updateDependentProperties()

            _listOfUpdates.value[index] =
                _listOfUpdates.value[index].updateUpgradeDataInTheList(level = planet.value.levelEnergyPerSecond)
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

    private fun UpdateData.updateUpgradeDataInTheList(level: Int): UpdateData {
        return this.copy(
            currentLevel = level,
            nextLevel = nextLevel(level = level),
            isMaxLevel = isMaxLevel(level = level),
            requiredToUp = Progress.requiredToUp(level = level)
        )
    }
}