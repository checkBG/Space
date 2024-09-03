package com.example.space.model

data class Planet(
    val coins: Int = 0,
    val levelMaxEnergy: Int = 1,
    val levelCoinsPerTap: Int = 1,
    val levelEnergyPerSecond: Int = 1,
    val coinsPerTap: Int = when(levelCoinsPerTap) {
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
    },
    val maxEnergy: Int = when (levelMaxEnergy) {
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
    },
    val energyPerSecond: Int = when(levelEnergyPerSecond) {
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
    },
    val energy: Int = maxEnergy
)