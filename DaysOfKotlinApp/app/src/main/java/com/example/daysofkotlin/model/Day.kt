package com.example.daysofkotlin.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Day(
    val dayNumber: Int,
    @StringRes val nameRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val describeRes: Int,
    @StringRes val codeRes: Int? = null
)
