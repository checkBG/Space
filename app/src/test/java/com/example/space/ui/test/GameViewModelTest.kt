package com.example.space.ui.test

import androidx.lifecycle.viewModelScope
import com.example.space.R
import com.example.space.model.GameViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_TapTheScreen_UpdateCoinsAndErrorFlagUnset() {
        viewModel.updateCoinsForTap()

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP, currentPlanetViewModel.coins)
        assertEquals(R.string.p_coin, viewModel.textTopAppBar.intValue)
    }

    @Test
    fun gameViewModel_FourTapTheScreenToUpdateTextTopAppBar_UpdateCoinsAndErrorFlagUnset() {
        val numberOfTaps = 4

        repeat(numberOfTaps) {
            viewModel.updateCoinsForTap()
        }

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP * numberOfTaps, currentPlanetViewModel.coins)
        assertEquals(R.string.pl_coin, viewModel.textTopAppBar.intValue)
    }

    @Test
    fun gameViewModel_FiftyTapTheScreenToUpdateTextTopAppBar_UpdateCoinsAndErrorFlagUnset() {
        val numberOfTaps = 50

        repeat(numberOfTaps) {
            viewModel.updateCoinsForTap()
        }

        val currentPlanetViewModel = viewModel.planet.value

        assertEquals(COINS_PER_FIRST_TAP * numberOfTaps, currentPlanetViewModel.coins)
        assertEquals(R.string.pla_coin, viewModel.textTopAppBar.intValue)
    }

    companion object {
        private const val COINS_PER_FIRST_TAP = 3
    }
}