package com.example.space.fundamental

import com.example.space.model.Coins
import com.example.space.model.Energy
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class Planet(coins: Int, energy: Int = 500) {
    private val dataClassCoins = Coins(coins = coins, coinsForTap = 1)
    val countOfCoins = dataClassCoins.coins
    val coinsForTap = dataClassCoins.coinsForTap

    private val dataClassEnergy = Energy(currentEnergy = energy)
    val energy = dataClassEnergy.currentEnergy
    val maxEnergy = dataClassEnergy.maxEnergy

    suspend fun addedEnergy(energy: Int, add: () -> Unit) = coroutineScope {
        while (energy < maxEnergy) {
            add()
            delay(1000)
        }
    }
}
