package com.example.space.ui.test

import com.example.space.R
import com.example.space.model.Aries
import com.example.space.model.GameViewModel
import com.example.space.model.Gemini
import com.example.space.model.Pisces
import com.example.space.model.Taurus
import com.example.space.model.Zodiac
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
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

    @Test
    fun zodiac_GetGemini() {
        val expectedZodiac = Gemini()

        val gotZodiac = Zodiac.getRightZodiacSign(expectedZodiac.coinsToUpgrade)
        assertTrue(gotZodiac is Gemini)
    }

    @Test
    fun zodiac_GetGemini_lessThanNeed() {
        val expectedZodiac = Gemini()

        val gotZodiac = Zodiac.getRightZodiacSign(expectedZodiac.coinsToUpgrade - 100)
        assertFalse(gotZodiac is Gemini)
    }

    @Test
    fun zodiac_GetGemini_moreThanNeed() {
        val expectedZodiac = Gemini()

        val gotZodiac = Zodiac.getRightZodiacSign(expectedZodiac.coinsToUpgrade + 100)
        assertTrue(gotZodiac is Gemini)
    }

    @Test
    fun zodiac_GetLastZodiac_moreThanNeed() {
        val gotZodiac = Zodiac.getRightZodiacSign(1000000000)
        assertTrue(gotZodiac is Pisces)
    }

    @Test
    fun zodiac_GetFirstZodiac() {
        val gotZodiac = Zodiac.getRightZodiacSign(0)
        assertTrue(gotZodiac is Aries)
    }

    @Test
    fun zodiac_GetSecondZodiac_moreThanNeed() {
        val gotZodiac = Zodiac.getRightZodiacSign(104)
        assertTrue(gotZodiac is Taurus)
    }

    companion object {
        private const val COINS_PER_FIRST_TAP = 3
    }
}