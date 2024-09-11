package com.example.space.ui.test

import com.example.space.R
import com.example.space.model.GameViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_TapTheScreen_UpdateCoinsAndErrorFlagUnset() {
        viewModel.updateCoinsForTap()

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP, currentPlanetViewModel.coins)
        assertEquals(R.string.p_coin, viewModel.planetAppBar.intValue)
    }

    @Test
    fun gameViewModel_FourTapTheScreenToUpdateTextTopAppBar_UpdateCoinsAndErrorFlagUnset() {
        val numberOfTaps = 4

        repeat(numberOfTaps) {
            viewModel.updateCoinsForTap()
        }

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP * numberOfTaps, currentPlanetViewModel.coins)
        assertEquals(R.string.pl_coin, viewModel.planetAppBar.intValue)
    }

    @Test
    fun gameViewModel_FiftyTapTheScreenToUpdateTextTopAppBar_UpdateCoinsAndErrorFlagUnset() {
        val numberOfTaps = 50

        repeat(numberOfTaps) {
            viewModel.updateCoinsForTap()
        }

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP * numberOfTaps, currentPlanetViewModel.coins)
        assertEquals(R.string.pla_coin, viewModel.planetAppBar.intValue)
    }

    companion object {
        private const val COINS_PER_FIRST_TAP = 3
    }
}