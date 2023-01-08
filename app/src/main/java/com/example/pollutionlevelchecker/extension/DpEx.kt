package com.example.pollutionlevelchecker.extension

import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

fun Dp.toSp(density: Density) = with(density) {
    toSp()
}