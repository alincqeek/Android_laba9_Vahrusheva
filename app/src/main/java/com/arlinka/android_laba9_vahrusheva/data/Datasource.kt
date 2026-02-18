package com.arlinka.android_laba9_vahrusheva.data

import com.arlinka.android_laba9_vahrusheva.R
import com.arlinka.android_laba9_vahrusheva.model.Game

class Datasource {
    fun loadAnimeList(): List<Game>{
        return listOf(
            Game(
                titleResourceId = R.string.game1,
                descriptionResourceId = R.string.game1_description,
                imageResourceId = R.drawable.game1
            ),
            Game(
                titleResourceId = R.string.game2,
                descriptionResourceId = R.string.game2_description,
                imageResourceId = R.drawable.game2
            ),
            Game(
                titleResourceId = R.string.game3,
                descriptionResourceId = R.string.game3_description,
                imageResourceId = R.drawable.game3
            ),
            Game(
                titleResourceId = R.string.game4,
                descriptionResourceId = R.string.game4_description,
                imageResourceId = R.drawable.game4
            ),
            Game(
                titleResourceId = R.string.game5,
                descriptionResourceId = R.string.game5_description,
                imageResourceId = R.drawable.game5
            ),
            Game(
                titleResourceId = R.string.game6,
                descriptionResourceId = R.string.game6_description,
                imageResourceId = R.drawable.game6
            ),
            Game(
                titleResourceId = R.string.game7,
                descriptionResourceId = R.string.game7_description,
                imageResourceId = R.drawable.game7
            ),
        )
    }
}