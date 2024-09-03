package com.example.space.model

data class Planet(
    val coins: Int = 0,
    val levelMaxEnergy: Int = 1,
    val levelCoinsPerTap: Int = 1,
    val levelCoinsPerSecond: Int = 1,
    val levelEnergyPerSecond: Int = 1,
    val energy: Int
) {
    companion object {
        fun initPlanet(): Planet = Planet(energy = 500)
    }
}