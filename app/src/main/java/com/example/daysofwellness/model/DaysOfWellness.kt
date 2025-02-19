package com.example.daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DaysOfWellness(
    @StringRes val day: Int,
    @StringRes val titleRes: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val descriptionRes: Int
)