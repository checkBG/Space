package com.example.space.model

import androidx.annotation.StringRes
import com.example.space.R

object Zodiac {
    private val zodiacs = listOf(
        Aries(),
        Taurus(),
        Gemini(),
        Cancer(),
        Leo(),
        Virgo(),
        Libra(),
        Scorpio(),
        Sagittarius(),
        Capricorn(),
        Aquarius(),
        Pisces()
    )

    fun getRightZodiacSign(currentCountOfCoins: Int): ZodiacSign {
        var gotZodiacSign: ZodiacSign = Aries()
        zodiacs.forEach { zodiac ->
            if (zodiac.coinsToUpgrade <= currentCountOfCoins) {
                gotZodiacSign = zodiac
            }
        }

        return gotZodiacSign
    }
}

abstract class ZodiacSign(
    @StringRes val zodiacSign: Int,
    val coinsToUpgrade: Int
)

class Aries(
    @StringRes zodiacSign: Int = ZodiacsEnum.Aries.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Aries.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Taurus(
    @StringRes zodiacSign: Int = ZodiacsEnum.Taurus.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Taurus.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Gemini(
    @StringRes zodiacSign: Int = ZodiacsEnum.Gemini.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Gemini.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Cancer(
    @StringRes zodiacSign: Int = ZodiacsEnum.Cancer.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Cancer.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Leo(
    @StringRes zodiacSign: Int = ZodiacsEnum.Leo.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Leo.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Virgo(
    @StringRes zodiacSign: Int = ZodiacsEnum.Virgo.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Virgo.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Libra(
    @StringRes zodiacSign: Int = ZodiacsEnum.Libra.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Libra.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Scorpio(
    @StringRes zodiacSign: Int = ZodiacsEnum.Scorpio.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Scorpio.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Sagittarius(
    @StringRes zodiacSign: Int = ZodiacsEnum.Sagittarius.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Sagittarius.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Capricorn(
    @StringRes zodiacSign: Int = ZodiacsEnum.Capricorn.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Capricorn.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Aquarius(
    @StringRes zodiacSign: Int = ZodiacsEnum.Aquarius.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Aquarius.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

class Pisces(
    @StringRes zodiacSign: Int = ZodiacsEnum.Pisces.zodiacSign,
    coinsToUpgrade: Int = ZodiacsEnum.Pisces.coinsToUpgrade
) : ZodiacSign(zodiacSign, coinsToUpgrade)

enum class ZodiacsEnum(
    @StringRes val zodiacSign: Int,
    val coinsToUpgrade: Int
) {
    Aries(zodiacSign = R.string.zodiac_sign_aries, coinsToUpgrade = 100),
    Taurus(zodiacSign = R.string.zodiac_sign_taurus, coinsToUpgrade = 1000),
    Gemini(zodiacSign = R.string.zodiac_sign_gemini, coinsToUpgrade = 5000),
    Cancer(zodiacSign = R.string.zodiac_sign_cancer, coinsToUpgrade = 10000),
    Leo(zodiacSign = R.string.zodiac_sign_leo, coinsToUpgrade = 15000),
    Virgo(zodiacSign = R.string.zodiac_sign_virgo, coinsToUpgrade = 25000),
    Libra(zodiacSign = R.string.zodiac_sign_libra, coinsToUpgrade = 100_000),
    Scorpio(zodiacSign = R.string.zodiac_sign_scorpio, coinsToUpgrade = 300_000),
    Sagittarius(zodiacSign = R.string.zodiac_sign_sagittarius, coinsToUpgrade = 1_000_000),
    Capricorn(zodiacSign = R.string.zodiac_sign_capricorn, coinsToUpgrade = 10_000_000),
    Aquarius(zodiacSign = R.string.zodiac_sign_aquarius, coinsToUpgrade = 100_000_000),
    Pisces(zodiacSign = R.string.zodiac_sign_pisces, coinsToUpgrade = 1_000_000_000),
}