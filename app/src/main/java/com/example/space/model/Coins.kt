package com.example.space.model

data class Coins(
    val coins: Int = 0,
    val coinsForTap: Int = 1
)

data class Energy(
    var maxEnergy: Int = 500,
    var currentEnergy: Int
)