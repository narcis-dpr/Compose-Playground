package com.example.myapplication.hlpers

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class City(
    val id: Int,
    @StringRes val nameResourceId: Int,
    @DrawableRes val imageResourceID: Int
)
