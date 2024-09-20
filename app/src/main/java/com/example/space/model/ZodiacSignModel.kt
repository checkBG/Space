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

    fun getRightZodiacSign(
        currentCountOfCoins: Int,
        currentZodiacSign: ZodiacSign? = null
    ): ZodiacSign {
        var gotZodiacSign: ZodiacSign = currentZodiacSign ?: Aries()
        zodiacs.forEach { zodiac ->
            if ((zodiac.coinsToUpdate <= currentCountOfCoins) && ((currentZodiacSign?.coinsToUpdate ?: Aries().coinsToUpdate) <= zodiac.coinsToUpdate)) {
                gotZodiacSign = zodiac
            }
        }

        return gotZodiacSign
    }
}

abstract class ZodiacSign(
    @StringRes val zodiacSign: Int,
    val requireCoins: Int,
    val coinsToUpdate: Int
)

class Aries(
    @StringRes zodiacSign: Int = ZodiacsEnum.Aries.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Aries.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Aries.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Taurus(
    @StringRes zodiacSign: Int = ZodiacsEnum.Taurus.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Taurus.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Taurus.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Gemini(
    @StringRes zodiacSign: Int = ZodiacsEnum.Gemini.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Gemini.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Gemini.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Cancer(
    @StringRes zodiacSign: Int = ZodiacsEnum.Cancer.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Cancer.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Cancer.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Leo(
    @StringRes zodiacSign: Int = ZodiacsEnum.Leo.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Leo.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Leo.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Virgo(
    @StringRes zodiacSign: Int = ZodiacsEnum.Virgo.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Virgo.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Virgo.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Libra(
    @StringRes zodiacSign: Int = ZodiacsEnum.Libra.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Libra.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Libra.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Scorpio(
    @StringRes zodiacSign: Int = ZodiacsEnum.Scorpio.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Scorpio.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Scorpio.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Sagittarius(
    @StringRes zodiacSign: Int = ZodiacsEnum.Sagittarius.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Sagittarius.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Sagittarius.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Capricorn(
    @StringRes zodiacSign: Int = ZodiacsEnum.Capricorn.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Capricorn.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Capricorn.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Aquarius(
    @StringRes zodiacSign: Int = ZodiacsEnum.Aquarius.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Aquarius.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Aquarius.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

class Pisces(
    @StringRes zodiacSign: Int = ZodiacsEnum.Pisces.zodiacSign,
    requireCoins: Int = ZodiacsEnum.Pisces.requireCoins,
    coinsToUpdate: Int = ZodiacsEnum.Pisces.coinsToUpdate
) : ZodiacSign(zodiacSign, requireCoins, coinsToUpdate)

enum class ZodiacsEnum(
    @StringRes val zodiacSign: Int,
    val requireCoins: Int,
    val coinsToUpdate: Int
) {
    Aries(
        zodiacSign = R.string.zodiac_sign_aries,
        requireCoins = 100,
        coinsToUpdate = 0
    ),
    Taurus(
        zodiacSign = R.string.zodiac_sign_taurus,
        requireCoins = 1000,
        coinsToUpdate = 100
    ),
    Gemini(
        zodiacSign = R.string.zodiac_sign_gemini,
        requireCoins = 5000,
        coinsToUpdate = 1000
    ),
    Cancer(
        zodiacSign = R.string.zodiac_sign_cancer,
        requireCoins = 10000,
        coinsToUpdate = 5000
    ),
    Leo(
        zodiacSign = R.string.zodiac_sign_leo,
        requireCoins = 15000,
        coinsToUpdate = 10000
    ),
    Virgo(
        zodiacSign = R.string.zodiac_sign_virgo,
        requireCoins = 25000,
        coinsToUpdate = 15000
    ),
    Libra(
        zodiacSign = R.string.zodiac_sign_libra,
        requireCoins = 100_000,
        coinsToUpdate = 25000
    ),
    Scorpio(
        zodiacSign = R.string.zodiac_sign_scorpio,
        requireCoins = 250_000,
        coinsToUpdate = 100_000
    ),
    Sagittarius(
        zodiacSign = R.string.zodiac_sign_sagittarius,
        requireCoins = 1_000_000,
        coinsToUpdate = 250_000
    ),
    Capricorn(
        zodiacSign = R.string.zodiac_sign_capricorn,
        requireCoins = 10_000_000,
        coinsToUpdate = 1_000_000
    ),
    Aquarius(
        zodiacSign = R.string.zodiac_sign_aquarius,
        requireCoins = 100_000_000,
        coinsToUpdate = 10_000_000
    ),
    Pisces(
        zodiacSign = R.string.zodiac_sign_pisces,
        requireCoins = 1_000_000_000,
        coinsToUpdate = 100_000_000
    )
}