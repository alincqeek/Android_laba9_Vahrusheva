package com.arlinka.android_laba9_vahrusheva.model

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Game(
    @StringRes val titleResourceId: Int,
    @StringRes val descriptionResourceId: Int,
    @DrawableRes val imageResourceId:Int
)